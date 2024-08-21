package the.big.bang.theory;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable{
    private final String name;
    private final String task;
    private final static int TASK_DELAY = 1000;

    @Override
    public void run() {
        System.out.printf("%s приступил к выполнению задачи %s\n", this.name, this.task);

        try {
            Thread.sleep(TASK_DELAY);
        } catch (InterruptedException exception) {
            System.out.printf("Задача %s была прервана %s\n", this.task, this.name);
            throw new RuntimeException(exception);
        }

        System.out.printf("%s выполнил задачу %s\n", this.name, this.task);
    }
}
