package school.faang.normalgame;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Наф-Наф", "Кирпич");
    }

    @Override
    public void run() {
        buildHouse(9000);
    }
}
