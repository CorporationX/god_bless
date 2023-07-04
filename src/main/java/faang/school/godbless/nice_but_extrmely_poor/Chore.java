package faang.school.godbless.nice_but_extrmely_poor;

import lombok.Getter;

@Getter
public class Chore implements Runnable {
    private final String nameOfTask;

    public Chore(String nameOfTask) {
        this.nameOfTask = nameOfTask;
    }

    @Override
    public void run() {
        String nameOfThread =  Thread.currentThread().getName();
        System.out.println("Task: " + getNameOfTask() + " starts executed by the " + nameOfThread);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread called: " + nameOfThread + " completed task: " + getNameOfTask() );
    }
}
