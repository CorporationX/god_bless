package Sprint_4_Task_The_Big_Bang_Theory;

public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ":" + " " + name + " is starting executing this task: " + task);
        try {
            Thread.sleep(2500L);
           //проверка на выкидывание ошибки
            // throw new InterruptedException("Task was interrupted due to an error");
        } catch (InterruptedException e) {
            System.out.println("Task was interrupted due to an error");
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ":" + " " + name + " has finished executing this task: " + task);
    }
}
