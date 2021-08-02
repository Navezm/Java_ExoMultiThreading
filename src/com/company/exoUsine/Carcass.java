package com.company.exoUsine;

public class Carcass implements Runnable {

    private final String securityScore;

    public Carcass(String securityScore) {
        this.securityScore = securityScore;
    }

    public String getSecurityScore() {
        return securityScore;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(4000);
            System.out.println("Carcass created");
            Thread.currentThread().interrupt();
        } catch (InterruptedException e) {
            return;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carcass{");
        sb.append("securityScore='").append(securityScore).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
