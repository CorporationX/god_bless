package faang.school.godbless.multithreading.parallelism_thread.normal_game;

public class Pig1Thread extends PigThread {

    public Pig1Thread(String pigName, MaterialEnum material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " начал строить дом из " + getMaterial().getName());
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " закончил строить дом из " + getMaterial().getName());
    }
}
