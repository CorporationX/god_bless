package school.faang.finallyanormalgame.maincode;

public class Pig1Thread extends PigThread {
    public Pig1Thread(String name, String material) {
        super("ниф ниф", "солома");
    }

    public void run() {
        System.out.println(getPigName() + " строит дом из " + getMaterial());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " закончил строить дом из " + getMaterial());
    }
}
