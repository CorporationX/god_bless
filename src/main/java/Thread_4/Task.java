package Thread_4;

public class Task implements Runnable {

    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println("Task " + name + " is performing");
        try {
            Thread.sleep(1000);
            System.out.println("Task " + name + " complete");
        } catch (InterruptedException e) {
            System.out.println("ERROR. Task " + name + " failing");
        }
    }

    public String getName() {
        return name;
    }

    public String getTask() {
        return task;
    }
}
