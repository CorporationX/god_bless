package faang.school.godbless.threads.bang;

public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.printf("%s принялся за работу %s\n", name, task);
        try {
            Thread.sleep(5500);
        } catch (InterruptedException e) {
            throw new RuntimeException(name + "прервал свою работу\n");
        }
        System.out.printf("%s завершил работу по %s\n", name, task);
    }
}
