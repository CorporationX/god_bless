package school.faang.spring3.hotel;

public class Officiant implements Runnable {
    private final House house;

    public Officiant(House house) {
        this.house = house;
    }

    @Override
    public void run() {
        house.collectFood();
    }
}
