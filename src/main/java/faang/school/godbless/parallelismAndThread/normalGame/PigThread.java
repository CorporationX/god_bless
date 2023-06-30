package faang.school.godbless.parallelismAndThread.normalGame;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PigThread extends Thread{
    private String pigName;
    private String material;

    @Override
    public void run() {
        buildHouse();
    }

    private void buildHouse() {
        System.out.println("Поток: " + Thread.currentThread().getName() + ": " + pigName + " начинает строительство дома из материала " + material);
        try {
            Thread.sleep((long) (Math.random() * 5000) + 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(pigName + " завершает строительство дома из материала " + material);
    }
}
