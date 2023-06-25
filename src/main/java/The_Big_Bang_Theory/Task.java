package The_Big_Bang_Theory;

public class Task implements Runnable {
    private String name;
    private String task;

    public String getName() {
        return name;
    }

    public String getTask() {
        return task;
    }

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(getName() + " starts task - " + getTask());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.out.println(getTask() + " execution by " +
                    getName() + " is interrupted");
        }
        System.out.println(getName() + " completed task - " + getTask());
    }
}
