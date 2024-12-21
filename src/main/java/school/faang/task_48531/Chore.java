package school.faang.task_48531;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    public void run() {
        System.out.println(Thread.currentThread().getName() + "выполняет задачу " + chore);
        try {
            Thread.sleep(3000);
            System.out.println("Задача выполненена");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
