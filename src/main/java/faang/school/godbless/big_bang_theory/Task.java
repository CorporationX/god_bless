package faang.school.godbless.big_bang_theory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(this.name + " начал выполнять задание - " + this.task);

        try {
            Thread.sleep(1000);
            System.out.println(this.name + " выполнил задание - " + this.task);
        } catch (InterruptedException ex) {
            System.out.println("Выполнение задачи " + this.task + " прервано!");
        }
    }
}
