package school.faang.sprint3.homes;

public class Muses extends Thread{
    private final House house;

    public Muses(House house) {
        this.house = house;
    }

    @Override
    public void run() {
        house.collectFood();
    }
}
