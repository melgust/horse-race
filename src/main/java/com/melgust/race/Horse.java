/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.melgust.race;

import java.util.Observable;

/**
 *
 * @author melgust
 */
public class Horse extends Observable implements Runnable {
    
    private String name;
    private int minimun;
    private int maximun;
    private int id;
    private int timeSleep;

    public Horse(String name, int minimun, int maximun, int id, int timeSleep) {
        this.name = name;
        this.minimun = minimun;
        this.maximun = maximun;
        this.id = id;
        this.timeSleep = timeSleep;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMinimun() {
        return minimun;
    }

    public void setMinimun(int minimun) {
        this.minimun = minimun;
    }

    public int getMaximun() {
        return maximun;
    }

    public void setMaximun(int maximun) {
        this.maximun = maximun;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimeSleep() {
        return timeSleep;
    }

    public void setTimeSleep(int timeSleep) {
        this.timeSleep = timeSleep;
    }

    @Override
    public void run() {
        int percentage = 0;
        int random;
        try {
            while(percentage < 100) {
                random = generateRandom();
                percentage += random;
                this.setChanged();
                this.notifyObservers(percentage);
                this.clearChanged();
                Thread.sleep(this.timeSleep);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + this.id + " stop");
        }
    }
    
    private int generateRandom() {
        int random = (int) Math.floor(Math.random() * (this.maximun - this.minimun + 1) + this.minimun);
        return random;
    }
    
}
