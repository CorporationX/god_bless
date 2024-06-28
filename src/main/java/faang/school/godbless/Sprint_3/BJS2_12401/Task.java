package faang.school.godbless.Sprint_3.BJS2_12401;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.Random;

@Data
@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начинает выполнение задания: " + task);
        try {
            int time = new Random().nextInt(4000) + 1000;
            Thread.sleep(time);
            System.out.println(name + " успешно завершил задание: " + task);
        } catch (InterruptedException e) {
            System.out.println("Задание " + task + " было прервано.");
        }
    }
}
