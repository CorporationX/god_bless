package faang.school.godbless.the_big_bang_theory;

public class Task implements Runnable {

    private final String name;
    private final String task;

    public Task(String name, String task) {
        this.name = name;
        this.task = task;
    }

    @Override
    public void run() {
        System.out.println(name + " Начал выполнять задание: " + task);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Выполнение прервалось");
            throw new RuntimeException(e);
        }
        System.out.println(name + " Выполнил задание: " + task);
    }
}
