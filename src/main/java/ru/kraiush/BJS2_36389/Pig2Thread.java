package ru.kraiush.BJS2_36389;

public class Pig2Thread extends PigThread {

    public Pig2Thread() {
        super("Naf-Naf", "sticks");
    }

    @Override
    public void run() {
        buildHouse(4000);
    }
}
