/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.firstassignment;

/**
 *
 * @author ealtzha
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FirstAssignment {
    
    // Custom exception class for empty file
    static class EmptyFileException extends Exception {
        public EmptyFileException(String message) {
            super(message);
        }
    }
    
    static class InvalidInputNumberException extends Exception {
        public InvalidInputNumberException(String message) {
            super(message);
        }
    }


    public static void main(String[] args) {
        
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the filename: ");
            String filename = scanner.nextLine();
            scanner.close();

            BufferedReader reader = new BufferedReader(new FileReader(filename));
            
            // Check if the file is empty
            if (!reader.ready()) {
                reader.close();
                throw new EmptyFileException("The file is empty.");
            }

            // Read the number of plants
            String line = reader.readLine();
            int n = Integer.parseInt(line);
            List<Plant> plants = new ArrayList<>();

            // Create plants
            for (int i = 0; i < n; i++) {
                line = reader.readLine();
                String[] tokens = line.split("[\\s\\t]+");
                
                if (tokens.length != 3) {
                    reader.close();
                    throw new InvalidInputNumberException("Given number is not the same with the plants count.");
                }
                
                String name = tokens[0];
                String type = tokens[1];
                int nutrients = Integer.parseInt(tokens[2]);
                
                if (nutrients <= 0) {
                    reader.close();
                    throw new InvalidInputNumberException("Negative nutrient value for plant.");
                }

                if (type.equals("p")) {
                    plants.add(new Puffs(name, nutrients));
                } else if (type.equals("d")) {
                    plants.add(new Deltatree(name, nutrients));
                } else if (type.equals("b")){
                    plants.add(new Parabush(name, nutrients));
                } else {
                    throw new InvalidInputNumberException("There is no that type of plant!");
                }
            }
            
            // Read the number of simulation days
            line = reader.readLine();
            int simulationDays = Integer.parseInt(line);

            IRadiation current_radiation = NoRadiation.Instance();
            int day = 1;

            if (simulationDays <= 0) {
                    reader.close();
                    throw new InvalidInputNumberException("Negative number for simulation days.");
            }
            while (day <= simulationDays) {
                IRadiation previous_radiation = current_radiation;
                current_radiation = current_radiation.Reaction(plants);

                System.out.println("day " + day + " current radiation: " + current_radiation.getClass().getSimpleName()
                        + " previous radiation: " + previous_radiation.getClass().getSimpleName());

                List<Plant> temp = new ArrayList<>();
                for (Plant p : plants) {
                    if (p.isAlive()) {
                        temp.add(p);
                    }
                }
                plants = temp;
                
                System.out.println("Current state of plants");
                System.out.println();
                for (Plant p : plants) {
                    System.out.println(p.getName() + " " + p.getNutrients() + " alive:" + p.isAlive() + " type:" + p.getClass().getSimpleName());
                }

                System.out.println("___________________________________________________");
                day++;
            }

            reader.close();
        } catch (InvalidInputNumberException ex) {
            System.out.println("Invalid input format: " + ex.getMessage());
        } catch (EmptyFileException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error reading the file: " + ex.getMessage());
        } catch (NumberFormatException ex) {
            System.out.println("Wrong input format.");
        }
        System.out.println("Press enter to finish...");
    }
}
