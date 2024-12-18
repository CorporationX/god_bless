package school.faang.sprint3.bjs_47700;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String name, String material) {
        super(name, material);
    }

    @Override
    public void run() {
        buildHouse();
    }
}
