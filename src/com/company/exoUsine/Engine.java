package com.company.exoUsine;

import java.util.Random;

public class Engine implements Runnable {

    Random rand = new Random();

    private final double power;

    public Engine(double power) {
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    @Override
    public void run() {
        try {
            int timeSleep = rand.nextInt(4) + 2;
            Thread.sleep(Long.parseLong((long)timeSleep+"000"));
            System.out.println("Engine created");
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            return;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Engine{");
        sb.append("power=").append(power);
        sb.append('}');
        return sb.toString();
    }
}
