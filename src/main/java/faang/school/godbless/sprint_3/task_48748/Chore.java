package faang.school.godbless.sprint_3.task_48748;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {
    private final String chore;

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("Поток \"" + currentThreadName + "\" начинает выполнение задачи \"" + chore + "\"");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Поток \"" + currentThreadName + "\" закончил выполнение задачи \"" + chore + "\"");
    }
}
