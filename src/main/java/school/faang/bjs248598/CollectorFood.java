package school.faang.bjs248598;

public class CollectorFood extends Thread {
    private final House house;

    public CollectorFood(House house) {
        this.house = house;
    }

    public void run() {
        house.collectFood();
    }
}
