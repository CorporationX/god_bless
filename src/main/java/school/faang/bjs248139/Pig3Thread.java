package school.faang.bjs248139;

public class Pig3Thread extends PigThread {

    public Pig3Thread(String pigName, String material) {
        super(pigName, material);
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " building out of " + getMaterial());
        try {
            Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(getPigName() + " finished");
    }

}
