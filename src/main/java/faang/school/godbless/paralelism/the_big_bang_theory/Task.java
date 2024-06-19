package faang.school.godbless.paralelism.the_big_bang_theory;

public class Task implements Runnable {
    private String personName;
    private String task;
    private final Long TASK_DURATION = 1000L;

    public Task(String personName, String task) {
        this.personName = personName;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(String.format("%s begins %s.", this.personName, this.task));
        try {
            Thread.sleep(TASK_DURATION);
            System.out.println(String.format("%s completed %s!", this.personName, this.task));
        } catch (InterruptedException e) {
            System.out.println(String.format("%s execution was interrupted!", this.task));
        }
    }
}
