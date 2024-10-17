package school.faang.mice_are_very_nice;

public class FoodCollector extends Thread {
    private final House house;

    public FoodCollector(House house) {
        this.house = house;

    }

    @Override
    public void run() {
        house.collectFood();
    }
}