package faang.school.godbless.kxnvg.bigbang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {

    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " приступил к выполнению задачи " + task);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println("Задача " + task + " была прервана");
            throw new RuntimeException("Задача прервана. InterruptedException");
        }
        System.out.println(name + " выполнил свою задачу " + task);
    }
}
