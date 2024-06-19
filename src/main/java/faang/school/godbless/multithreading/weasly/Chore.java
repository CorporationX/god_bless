package faang.school.godbless.multithreading.weasly;

public class Chore implements Runnable{

    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }
    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println("Поток " + threadName + " начал выполнение задачи " + chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Поток " + threadName + " закончил выполнение задачи " + chore);
    }
}
