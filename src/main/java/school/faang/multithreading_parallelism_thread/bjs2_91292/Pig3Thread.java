package school.faang.multithreading_parallelism_thread.bjs2_91292;

public class Pig3Thread extends PigThread {
    public Pig3Thread() {
        super("Нуф-нуф", "кирпичи");
    }

    @Override
    public void run() {
        System.out.println(getName() + " начал строить дом из " + getMaterial());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println(getName() + " закончил строить дом из " + getMaterial());
    }
}
