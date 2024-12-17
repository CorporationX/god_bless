package school.faang.sprint_3.task_43558;

public record Task(String name, String task) implements Runnable {
    private static final int SLEEP_TIME = 3000;
    @Override
    public void run() {
        System.out.println(name + " начинает выполнять задачу " + task);
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            System.out.println("Выполнение задачи " + task + " было прервано!");
        }
        System.out.println(name + " выполнил задачу " + task);
    }
}
