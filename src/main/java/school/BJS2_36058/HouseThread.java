package school.BJS2_36058;

public class HouseThread implements Runnable {

    private final House house;

    public HouseThread(House house) {
        this.house = house;
    }

    public void run() {
        house.collectFood();
    }
}
