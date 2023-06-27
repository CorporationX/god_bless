package faang.school.godbless.bigBang;

import lombok.Data;
import lombok.NonNull;

@Data
public class Task implements Runnable{
    @NonNull
    private String name;
    @NonNull
    private String task;

    @Override
    public void run() {
        System.out.println("Задание начало выполнятся");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
    }
}
