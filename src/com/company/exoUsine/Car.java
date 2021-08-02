package com.company.exoUsine;

public class Car implements Runnable {

    private final Engine engine;
    private final Bodywork bodywork;
    private final Carcass carcass;

    public Car(Engine engine, Bodywork bodywork, Carcass carcass) {
        this.engine = engine;
        this.bodywork = bodywork;
        this.carcass = carcass;
    }

    public Engine getEngine() {
        return engine;
    }

    public Bodywork getBodywork() {
        return bodywork;
    }

    public Carcass getCarcass() {
        return carcass;
    }

    @Override
    public void run() {
        try {
            System.out.println("Beginning of the creation");
            Thread.sleep(2000);
            System.out.println(this);
            System.out.println("Car created");
        } catch (InterruptedException e) {
            return;
        }
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append(engine);
        sb.append(' ').append(bodywork);
        sb.append(' ').append(carcass);
        sb.append('}');
        return sb.toString();
    }
}
