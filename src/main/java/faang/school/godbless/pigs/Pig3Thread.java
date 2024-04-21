package faang.school.godbless.pigs;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public long getConstructionTime() {
        return 4000; // 4 секунды
    }
}
