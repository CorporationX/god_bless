package school.faang.bjs2_91310;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private String chore;
    private final int timeInMillis;

    @Override
    public void run() {
        System.out.printf("%s выполняет: %s%n",
                Thread.currentThread().getName(), chore);

        try {
            Thread.sleep(timeInMillis);
            System.out.printf("%s завершил: %s%n",
                    Thread.currentThread().getName(), chore);
        } catch (InterruptedException e) {
            throw new RuntimeException(
                    String.format("Поток %s был прерван во время выполнения: %s",
                            Thread.currentThread().getName(), chore), e);
        }
    }
}
