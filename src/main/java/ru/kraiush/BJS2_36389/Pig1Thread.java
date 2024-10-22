package ru.kraiush.BJS2_36389;

public class Pig1Thread extends PigThread {

    public Pig1Thread() {
        super("Nif-Nif", "straw");
    }

    @Override
    public void run() {
        buildHouse(2000);
    }
}
