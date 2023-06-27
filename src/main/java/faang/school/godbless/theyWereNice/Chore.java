package faang.school.godbless.theyWereNice;

import lombok.Data;
import lombok.NonNull;

@Data
public class Chore implements Runnable{
    @NonNull
    private String task;

    @Override
    public void run() {
        System.out.println("Задача " + Thread.currentThread().getName() +
                " начала выполняться.");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.getMessage();
            Thread.currentThread().interrupt();
        }
    }
}
