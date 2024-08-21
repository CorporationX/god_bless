package faang.school.godbless.bigBang;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable{
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.println(name + " начинает работу над задачей: " + task);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("задача "+ task +" исполнителя " + name + " прервана");
            return;
        }
        System.out.println("задача " + task + " выполнена, исполнитель: " + name);
    }
}
