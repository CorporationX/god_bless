package faang.school.godbless.domain.task_very_nice_but;

public class Chore implements Runnable {

    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " выполнение задачи: " + chore);
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName() + " завершил задачу: " + chore);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
