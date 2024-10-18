package ru.kraiush.BJS2_36389;

public class Pig3Thread extends PigThread {

    public Pig3Thread() {
        super("Nuk-Nuk", "bricks");
    }

    @Override
    public void run() {
        buildHouse(6000);
    }
}
