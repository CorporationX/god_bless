package school.faang.BJS236364;

public class Pig2Thread extends PigThread {
    public Pig2Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println("Поросенок 2: " + getPigName() + " " + " использует материал: " + getMaterial());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
