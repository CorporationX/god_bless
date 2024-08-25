package they_were_very_nice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Chore implements Runnable {

    private String choreName;

    @Override
    public void run() {
        try {
            System.out.printf("Задача %s выполняется в потоке %s%n",
                    choreName,
                    Thread.currentThread().getName()
            );
            Thread.sleep(2000L);
            System.out.printf("Задача %s выполнена%n",choreName);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
}
