package school.faang.multithreading_parallelism_thread.bjs2_91292;

public class Pig2Thread extends PigThread {
    public Pig2Thread() {
        super("Наф-Наф", "палки");
    }

    @Override
    public void run() {
        System.out.println(getName() + " начал строить дом из " + getMaterial());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println(getName() + " закончил строить дом из " + getMaterial());
    }
}
