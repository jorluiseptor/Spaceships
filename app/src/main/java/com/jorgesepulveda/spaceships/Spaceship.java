package com.jorgesepulveda.spaceships;

import java.util.Random;

/**
 * Created by Jorge on 6/13/2016.
 */

public class Spaceship {
    private String name;
    private String state;
    private int hitPoints = 100;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    /// <summary>
    /// Attack another ship.
    /// </summary>
    /// <param name="enemyShip">The spaceship object that will be attacked.</param>
    public void Attack(Spaceship enemyShip, Integer hit)
    {
        //random object to create random numbers.
        Random rand = new Random();

        //a hit amount minus a random number between 0 and 101
        hit = (hit * rand.nextInt(100)) / 100;
        enemyShip.setHitPoints(enemyShip.getHitPoints() - hit);

    }
}
