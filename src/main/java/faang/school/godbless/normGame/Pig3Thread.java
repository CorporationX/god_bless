package faang.school.godbless.normGame;
import lombok.NonNull;

public class Pig3Thread extends PigThread{
    public Pig3Thread(@NonNull String pigName, @NonNull String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " построил дом из " + getMaterial());
    }
}