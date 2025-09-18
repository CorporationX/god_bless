package school.faang.bjs2_89908;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Task implements Runnable {
    @SuppressWarnings({"checkstyle:MemberName", "checkstyle:AbbreviationAsWordInName"})
    private final int SLEEPING_TIME = 5000;
    private String name;
    private String task;

    @Override
    public void run() {
        System.out.printf("Задача '%s' начала выполняться.%n", name);
        try {
            Thread.sleep(SLEEPING_TIME);
        } catch (InterruptedException e) {
            System.out.printf("Потоку %s не удалось уснуть во время выполнения задачи '%s', бессонница...%n)",
                    Thread.currentThread().getName(), name);
        }
        System.out.printf("Задача '%s' закончила выполняться.%n", name);
    }
}
