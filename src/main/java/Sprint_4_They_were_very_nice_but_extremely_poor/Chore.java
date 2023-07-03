package Sprint_4_They_were_very_nice_but_extremely_poor;

public class Chore implements Runnable {

    private String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " " + chore);

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " " + "закончил " + chore);

    }
}
