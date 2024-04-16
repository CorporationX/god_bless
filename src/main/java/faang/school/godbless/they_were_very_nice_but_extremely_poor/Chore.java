package faang.school.godbless.they_were_very_nice_but_extremely_poor;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println("Задача " + chore + " выполняется потоком: " + Thread.currentThread().getName());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Задача " + chore + " прервана");
            throw new RuntimeException(e);
        }
        System.out.println("Задача " + chore + " выполнена потоком: " + Thread.currentThread().getName());
    }
}
