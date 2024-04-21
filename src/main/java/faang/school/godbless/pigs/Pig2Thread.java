package faang.school.godbless.pigs;

public class Pig2Thread extends PigThread {
    public Pig2Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public long getConstructionTime() {
        return 3000;
    }
}