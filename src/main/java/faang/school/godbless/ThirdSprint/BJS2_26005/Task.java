package faang.school.godbless.ThirdSprint.BJS2_26005;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    String name;
    String task;

    @Override
    public void run() {
        System.out.println(name + " приступил к заданию " + task);
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread.sleep(1000);
                System.out.println(name + " усердно работает");
            } catch (InterruptedException e) {
                System.out.println("Задание было прервано!!");
                Thread.currentThread().interrupt();
            }
        }
        System.out.println(name + " заврершил задание " + task);
    }
}
