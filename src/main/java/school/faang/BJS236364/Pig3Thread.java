package school.faang.BJS236364;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println("Поросенок 3: " + getPigName() + " " + " использует материал: " + getMaterial());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
