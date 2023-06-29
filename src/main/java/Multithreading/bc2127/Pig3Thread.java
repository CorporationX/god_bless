package Multithreading.bc2127;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String pigName, int material) {
        super(pigName, material);
    }

    public void run() {
        try {
            System.out.println("Для поросенка: " + getPigName() + " начали строить дом из материала: " + getMaterial());
            Thread.sleep(3000);
            System.out.println("Строительство дома для " + getPigName() + " закончено");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
