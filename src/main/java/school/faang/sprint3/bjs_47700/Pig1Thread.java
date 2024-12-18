package school.faang.sprint3.bjs_47700;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String name, String material) {
        super(name, material);
    }

    @Override
    public void run() {
        buildHouse();
    }
}
