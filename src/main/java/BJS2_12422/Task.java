package BJS2_12422;

public class Task implements Runnable {
    String name;
    String task;

    @Override
    public void run() {
        System.out.println("Задача в работе");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Задача завершена");
    }

    public Task(String name, String task) {
        this.task = task;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getTask() {
        return task;
    }
}
