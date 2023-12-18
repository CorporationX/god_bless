package faang.school.godbless.The_Big_Bang_Theory;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Task implements Runnable {
    public String name;
    public String task;

    @Override
    public void run() {
        try {
            System.out.println(name + " stars the task \"" + task + "\"");
            Thread.sleep(5000);
            System.out.println("\"" + task + "\" выполнено.");
        } catch (InterruptedException e) {
            System.out.println("Task interrupted");

        }
    }

}
