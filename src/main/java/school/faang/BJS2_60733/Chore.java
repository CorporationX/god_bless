package school.faang.BJS2_60733;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Chore implements Runnable {

    @NonNull
    private final String chore;

    @Override
    public void run() {
        try {
            System.out.printf("Поток %s выполняет задачу '%s'\n", Thread.currentThread().getName(), getChore());
            Thread.sleep(5000);
            System.out.printf("Задача '%s' завершена\n", getChore());
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.printf("Задача прервана: %s\n", getChore());
        }
    }
}
