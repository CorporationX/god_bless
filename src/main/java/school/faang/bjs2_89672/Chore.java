package school.faang.bjs2_89672;

public class Chore implements Runnable {
    private final String chore;

    public Chore(String chore) { // всего один аргумент, поэтому lombok не использую
        this.chore = chore;
    }


    @Override
    public void run() {
        System.out.println("Задача \"" + chore + "\" выполняется..." +
                "\nПоток: " + Thread.currentThread().getName()
                + "\n---\n");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.err.printf("Задача %s была прервана", chore);
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.printf("Задача %s выполнена!\n", chore);
    }

}
