package faang.school.godbless.goodButBad;

public class Chore implements Runnable{
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName + " начинает выполнение задачи: " + chore);
            Thread.sleep((int)(Math.random() * 3000));
            System.out.println(threadName + " завершил выполнение задачи: " + chore);
        } catch (InterruptedException e) {
            System.err.println("Задача " + chore + " была прервана.");
        }
    }
}
