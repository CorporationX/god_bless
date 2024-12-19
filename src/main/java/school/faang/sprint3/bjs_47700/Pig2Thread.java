package school.faang.sprint3.bjs_47700;

public class Pig2Thread extends PigThread {
    public Pig2Thread(String name, String material) {
        super(name, material);
    }

    @Override
    public void run() {
        buildHouse();
    }
}
