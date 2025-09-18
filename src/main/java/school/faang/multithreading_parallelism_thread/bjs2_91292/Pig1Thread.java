package school.faang.multithreading_parallelism_thread.bjs2_91292;

public class Pig1Thread extends PigThread {
    public Pig1Thread() {
        super("Ниф-Ниф", "солома");
    }

    @Override
    public void run() {
        System.out.println(getName() + " начал строить дом из " + getMaterial());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        System.out.println(getName() + " закончил строить дом из " + getMaterial());
    }
}
