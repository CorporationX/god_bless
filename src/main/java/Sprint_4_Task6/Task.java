package Sprint_4_Task6;

public class Task implements Runnable {

    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("Задание выполняется");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            System.out.println("прерывание задачи");
        }

    }
}
