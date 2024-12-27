package faang.school.godbless.sprint_3.task_48748;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Chore implements Runnable {

    private static final int CHORE_EXECUTION_TIME_IN_MILLISECONDS = 5000;

    private final String chore;

    @Override
    public void run() {
        String currentThreadName = Thread.currentThread().getName();
        System.out.println("Поток \"" + currentThreadName + "\" начинает выполнение задачи \"" + chore + "\"");
        try {
            Thread.sleep(CHORE_EXECUTION_TIME_IN_MILLISECONDS);
        } catch (InterruptedException e) {
            System.out.println("Произошло исключение!" + e);
        }
        System.out.println("Поток \"" + currentThreadName + "\" закончил выполнение задачи \"" + chore + "\"");
    }
}
