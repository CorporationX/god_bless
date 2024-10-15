package school.faang.normalgame;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Нуф-Нуф", "доски");
    }

    @Override
    public void run() {
        buildHouse(6000);
    }
}
