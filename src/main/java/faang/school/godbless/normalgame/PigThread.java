import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class PigThread extends Thread {
    private String pigName;
    private String material;
    private int time;

    @Override
    public void run() {
        System.out.println("Строительство начал " + pigName + " из " + material);
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Строительство закончил " + pigName + " дом построен из " + material);
    }
}
