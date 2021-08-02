package com.company.exoUsine;

public class Factory{

    static void createCar(String color, String securityScore, double power) {
        Carcass carcass = new Carcass(securityScore);
        Engine engine = new Engine(power);
        Bodywork bodywork = new Bodywork(color);

        Thread c = new Thread(carcass);
        Thread e = new Thread(engine);
        Thread b = new Thread(bodywork);

        Thread timer = new Thread(() -> {
            try {
                System.out.println("In 5 sec it starts");
                Thread.sleep(5000);
                if (c.isInterrupted() && e.isInterrupted() && b.isInterrupted()) {
                    Car car = new Car(engine, bodywork, carcass);
                    Thread tCar = new Thread(car);
                    tCar.start();
                } else {
                    System.out.println("Couldn't create the car");
                    e.interrupt();
                }
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        c.start();
        e.start();
        b.start();
        timer.start();

    }

}
