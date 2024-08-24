package faang.school.godbless.task25899;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable{
    String name;
    String task;
    @Override
    public void run() {
        System.out.println("Задача " + task + " запущена в работу.");
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if(Thread.interrupted()){
            Thread.currentThread().interrupt();
            System.out.println("Задача " + task + " остановлена.");
        }
    }
}
