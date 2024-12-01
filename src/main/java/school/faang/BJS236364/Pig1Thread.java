package school.faang.BJS236364;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println("Поросенок 1: " + getPigName() + " " + " использует материал: " + getMaterial());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Game over!");
    }
}
