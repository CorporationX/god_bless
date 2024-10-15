package school.faang.normalgame;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Ниф-Ниф", "Солома");
    }

    @Override
    public void run() {
        buildHouse(2000);
    }
}
