package faang.school.godbless;

public class Task implements Runnable{
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(name + " начал работу с " + task);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            System.out.println("прервано");
            throw new RuntimeException(e);
        }
    }
}
