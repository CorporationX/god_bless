package faang.school.godbless.sprint_3.the_big_bang_theory;

public class Task implements Runnable {
    private String name;
    private String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.printf("%s начал выполнять задачу %s.\n", name, task);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.out.printf("%s выполнил задачу.\n", name);
    }
}