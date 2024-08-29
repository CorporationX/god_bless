package faang.school.godbless.dolbahlop.multithreading.parallelism;

import lombok.AllArgsConstructor;

import javax.xml.namespace.QName;

@AllArgsConstructor
public class Task implements Runnable {
    private String name;
    private String task;
    @Override
    public void run() {
        System.out.println(name + " just has started '" + task + "' ");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            System.out.println("The task was interrupted");
            throw new RuntimeException(e);
        }
        System.out.println("The task '" + task + "' was completed");
    }
}
