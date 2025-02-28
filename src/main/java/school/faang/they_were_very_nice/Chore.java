package school.faang.they_were_very_nice;

public class Chore implements Runnable {

    public static final int SLEEP_TIME = 1000;

    private final String chore;

    public Chore(String chore) {
        this.chore = chore;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(SLEEP_TIME);
        } catch (InterruptedException e) {
            throw new RuntimeException("Работа потока была прервана");
        }
        System.out.println("chore: " + chore);
    }

}
