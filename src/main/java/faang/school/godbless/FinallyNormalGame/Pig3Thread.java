package faang.school.godbless.FinallyNormalGame;

public class Pig3Thread extends PigThread {
    private static final Material MATERIAL = new Material("Brick", 8);

    public Pig3Thread(String pigName) {
        super(pigName, MATERIAL);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(MATERIAL.getComplexity() * 100L);
            System.out.println(getPigName() + "'s " + MATERIAL.getName() + " house has been built!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
