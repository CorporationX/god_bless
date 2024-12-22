package school.faang.theywereverynicebutextremelypoor;

public class Chore implements Runnable {
    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println("Поток " + Thread.currentThread().getName() + " выполняет задачу " + chore);
            Thread.sleep(1000);
            System.out.println("Задача " + chore + " выполнена");
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " была прервана!");
        }
    }
}
