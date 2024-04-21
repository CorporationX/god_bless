package faang.school.godbless.pigs;

public class Pig1Thread extends PigThread{
    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public long getConstructionTime() {
        return 2000;
    }
}
