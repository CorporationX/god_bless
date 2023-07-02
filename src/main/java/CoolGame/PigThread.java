package CoolGame;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PigThread extends Thread{
    private String pigName;
    private String material;

    @Override
    public void run() {
        System.out.printf("%s is building his house with %s\n", pigName, material);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s is finished\n", pigName);
    }
}
