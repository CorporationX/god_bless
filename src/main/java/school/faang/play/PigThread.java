package school.faang.play;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PigThread extends Thread{
    private String pigName;
    private String material;

    @Override
    public void run() {
        System.out.println("Я строю дом из " + material);
        try {
            for (int i = 0; i < 5; i++) {
                Thread.sleep(1000);
                System.out.println("Я " + pigName + " продолжаю строить");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }


}
