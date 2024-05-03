/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.firstassignment;

/**
 *
 * @author ealtzha
 */
import java.util.List;

interface IRadiation {
    IRadiation Reaction(List<Plant> plants);
}

class Alpha implements IRadiation {
    private Alpha() { }

    private static Alpha instance = null;

    public static Alpha Instance() {
        if (instance == null) {
            instance = new Alpha();
        }
        return instance;
    }

    /**
     * 
     * @param plants
     * @return this returns an instance for the given radiation.
     */
    @Override
    public IRadiation Reaction(List<Plant> plants) {
        int deltaNeed = 0;
        int alphaNeed = 0;

        for (Plant plant : plants) {
            plant.react(this);
            alphaNeed += plant.getNeedAlpha();
            deltaNeed += plant.getNeedDelta();
        }

        System.out.println("alpha_need:" + alphaNeed + " delta_need:" + deltaNeed);

        if (alphaNeed >= deltaNeed + 3) {
            return Instance();
        } else if (alphaNeed + 3 <= deltaNeed) {
            return Delta.Instance();
        } else {
            return NoRadiation.Instance();
        }
    }
}

class NoRadiation implements IRadiation {
    private NoRadiation() { }

    private static NoRadiation instance = null;

    public static NoRadiation Instance() {
        if (instance == null) {
            instance = new NoRadiation();
        }
        return instance;
    }

    /**
     * 
     * @param plants
     * @return this returns an instance for the given radiation.
     */
    @Override
    public IRadiation Reaction(List<Plant> plants) {
        int deltaNeed = 0;
        int alphaNeed = 0;

        for (Plant plant : plants) {
            plant.react(this);
            alphaNeed += plant.getNeedAlpha();
            deltaNeed += plant.getNeedDelta();
        }

        System.out.println("alpha_need:" + alphaNeed + " delta_need:" + deltaNeed);

        if (alphaNeed >= deltaNeed + 3) {
            return Alpha.Instance();
        } else if (alphaNeed + 3 <= deltaNeed) {
            return Delta.Instance();
        } else {
            return Instance();
        }
    }
}

class Delta implements IRadiation {
    private Delta() { }

    private static Delta instance = null;

    public static Delta Instance() {
        if (instance == null) {
            instance = new Delta();
        }
        return instance;
    }

    /**
     * 
     * @param plants
     * @return this returns an instance for the given radiation.
     */
    @Override
    public IRadiation Reaction(List<Plant> plants) {
        int deltaNeed = 0;
        int alphaNeed = 0;

        for (Plant plant : plants) {
            plant.react(this);
            alphaNeed += plant.getNeedAlpha();
            deltaNeed += plant.getNeedDelta();
        }

        System.out.println("alpha_need:" + alphaNeed + " delta_need:" + deltaNeed);

        if (alphaNeed >= deltaNeed + 3) {
            return Alpha.Instance();
        } else if (alphaNeed + 3 <= deltaNeed) {
            return Instance();
        } else {
            return NoRadiation.Instance();
        }
    }
}
