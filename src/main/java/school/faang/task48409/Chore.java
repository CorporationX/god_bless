package school.faang.task48409;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + Constants.IN_PROGRESS + chore);
            Thread.sleep(1000);
            System.out.println(chore + Constants.DONE);
        } catch (InterruptedException e) {
            System.out.println("Задача : " + chore + Constants.INTERRUPTED);
        }
    }
}
