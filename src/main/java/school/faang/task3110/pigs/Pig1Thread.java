package school.faang.task3110.pigs;

public class Pig1Thread extends PigThread{
    public Pig1Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        try {
            System.out.println(getPigName() + " строит дом из " + getMaterial());
            Thread.sleep(1000);
            System.out.println(getPigName() + " достроил дом из " + getMaterial());
        } catch (InterruptedException e) {
            throw new IllegalStateException(e.getMessage());
        }
    }
}
