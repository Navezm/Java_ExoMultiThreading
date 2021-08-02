package com.company.exoUsine;

public class Bodywork implements Runnable {

    private final String color;

    public Bodywork(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
            System.out.println("Bodywork created");
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            return;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Bodywork{");
        sb.append("color='").append(color).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
