package school.faang.task_48828;

public class Mouse extends Thread {
    private final House house;

    public Mouse(House house) {
        this.house = house;
    }

    @Override
    public void run() {
        house.collectFood();
    }
}