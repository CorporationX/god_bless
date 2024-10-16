package school.faang.theywereverynicebutextremelypoor;

public class Chore implements Runnable {

    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " выполняет задачу " + chore);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new IllegalStateException("Задача была прервана: " + chore, e);
        }
        System.out.println(Thread.currentThread().getName() + " завершил выполнение задачи " + chore);
    }
}
