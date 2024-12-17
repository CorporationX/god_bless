package school.faang.task_48559;

public class Chore implements Runnable {

    private final String chore;
    private static final int THREAD_SLEEP = 1000;

    public Chore(String chore) {
        if (chore == null || chore.trim().isEmpty()) {
            throw new IllegalArgumentException("Задача не может быть пустой");
        }
        this.chore = chore;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName() + " делаю задачу: " + getChore());
        try {
            Thread.sleep(THREAD_SLEEP);
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " не выполнена");
        }
        System.out.println("Задача " + chore + " выполнена");
    }

    public String getChore() {
        return chore;
    }
}