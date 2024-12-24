package school.faang.bjs248999;


public class Officiant extends Thread {

    private final House house;

    public Officiant(House house) {
        this.house = house;
    }

    @Override
    public void run() {
        house.collectFood();
    }
}
