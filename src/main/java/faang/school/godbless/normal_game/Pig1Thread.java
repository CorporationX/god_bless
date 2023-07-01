package faang.school.godbless.normal_game;

public class Pig1Thread extends PigThread {

    public Pig1Thread(String pigName, int material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println("Поросенок " + this.getPigName() + " строит дом из материала: " + this.getMaterials()[this.getMaterial()]);
        try {
            Thread.sleep(this.getMaterial() * 3000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getPigName() + " построил дом");
    }
}
