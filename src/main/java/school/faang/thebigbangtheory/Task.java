package school.faang.thebigbangtheory;

public class Task implements Runnable {
    private final String name;
    private final String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.printf("\nНачато выполнение - %s : %s",name,task);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException("Задача была прервана");
        }
        System.out.printf("\n%s : %s - завершена",name,task);
    }
}
