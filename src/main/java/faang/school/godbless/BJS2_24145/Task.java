package faang.school.godbless.BJS2_24145;

import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начал выполнять задание " + task);

        try {
            Thread.sleep(new Random().nextInt(1000, 5000));
        } catch (InterruptedException e) {
            System.out.println(name + " было прервано.");
            return;
        }

        System.out.println(name + " завершил задание " + task);
    }
}
