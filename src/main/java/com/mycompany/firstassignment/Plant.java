/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.firstassignment;

/**
 * This is a plant class, which implements the simple plant with name, nutrients and living parameters and methods. 
 * @author Zhainagul Altynbek kyzy (V7I2JB)
 */

public abstract class Plant {
    String name;
    int nutrients;
    boolean living;

    /**
     * This is a constructor with a specified name, nutrients.
     * @param name the name of the plant 
     * @param nutrients the nutrient level of a plant
     */
    public Plant(String name, int nutrients) {
        this.name = name;
        this.nutrients = nutrients;
    }

    public String getName() {
        return name;
    }

    public int getNutrients() {
        return nutrients;
    }

    /**
     * This modifies the nutrients level of the plant with given parameter e.
     * @param e this is added to the already existing nutrients.
     */
    public void modifyNutrients(int e) {
        nutrients += e;
    }

    public abstract int getNeedAlpha();

    public abstract int getNeedDelta();

    public abstract boolean isAlive();
    
    public abstract void react(IRadiation radiation);
}

/**
 * This is the class Puffs which extends the class Plant
 * @author Zhainagul Altynbek kyzy
 */
class Puffs extends Plant {
    public Puffs(String name, int nutrients) {
        super(name, nutrients);
    }

    /**
     * This is the method for Puffs which checks if the plant is alive or not
     * @return this returns true if 10 > nutrients > 0 or false value otherwise
     */
    @Override
    public boolean isAlive() {
        return getNutrients() > 0 && getNutrients() < 10;
    }

    /**
     * This is a method which modifies the nutrients of a plant according to the given radiation.
     * @param radiation 
     */
    @Override
    public void react(IRadiation radiation) {
        if (radiation.getClass().getSimpleName().equals("Alpha")) {
            modifyNutrients(2);
        } else if (radiation.getClass().getSimpleName().equals("Delta")) {
            modifyNutrients(-2);
        } else {
            modifyNutrients(-1);
        }
    }

    /**
     * This is the method which calculates the need for alpha.
     * @return this returns 10 - nutrients for the alpha need.
     */
    @Override
    public int getNeedAlpha() {
        if(isAlive()){
            return 10 - getNutrients();
        } else{
            return 0;
        }
    }

    /**
     * This is the method which calculates the need for delta.
     * @return this returns 0. 
     */
    @Override
    public int getNeedDelta() {
        return 0;
    }
}

/**
 * This is the class Deltatree which extends the class Plant
 * @author Zhainagul Altynbek kyzy
 */
class Deltatree extends Plant {
    public Deltatree(String name, int nutrients) {
        super(name, nutrients);
    }
    
    
    /**
     * This is the method for Deltatree which checks if the plant is alive or not
     * @return this returns true if nutrients > 0 or false value otherwise
     */
    @Override
    public boolean isAlive() {
        return getNutrients() > 0;
    }

    /**
     * This is a method which modifies the nutrients of a plant according to the given radiation.
     * @param radiation 
     */
    @Override
    public void react(IRadiation radiation) {
        if (radiation.getClass().getSimpleName().equals("Alpha")) {
            modifyNutrients(-3);
        } else if (radiation.getClass().getSimpleName().equals("Delta")) {
            modifyNutrients(4);
        } else {
            modifyNutrients(-1);
        }
    }

    /**
     * This is the method which calculates the need for alpha.
     * @return this returns 0.
     */
    @Override
    public int getNeedAlpha() {
        return 0;
    }

    /**
     * This is the method which calculates the need for delta.
     * @return this returns +4 if 5 > nutrients, returns +1 if 10 >= nutrients >= 5 and 0 otherwise for the delta need.
     */
    @Override
    public int getNeedDelta() {
        if (isAlive() && getNutrients() < 5) {
            return 4;
        } else if (getNutrients() >= 5 && getNutrients() <= 10) {
            return 1;
        } else {
            return 0;
        }
    }
}

/**
 * This is the class Parabush which extends the class Plant
 * @author Zhainagul Altynbek kyzy
 */
class Parabush extends Plant {
    public Parabush(String name, int nutrients) {
        super(name, nutrients);
    }
    
    /**
     * This is the method for Parabush which checks if the plant is alive or not
     * @return this returns true if nutrients > 0 or false value otherwise
     */
    @Override
    public boolean isAlive() {
        return getNutrients() > 0;
    }

    /**
     * This is a method which modifies the nutrients of a plant according to the given radiation.
     * @param radiation 
     */
    @Override
    public void react(IRadiation radiation) {
        if (radiation.getClass().getSimpleName().equals("Alpha") || radiation.getClass().getSimpleName().equals("Delta")) {
            modifyNutrients(1);
        } else {
            modifyNutrients(-1);
        }
    }

    /**
     * This is the method which calculates the need for alpha.
     * @return this returns 0.
     */
    @Override
    public int getNeedAlpha() {
        return 0;
    }

    /**
     * This is the method which calculates the need for delta.
     * @return this returns 0.
     */
    @Override
    public int getNeedDelta() {
        return 0;
    }
}
