package faang.school.godbless.FinallyNormalGame;

public class Pig2Thread extends PigThread {
    private static final Material MATERIAL = new Material("Stick", 12);

    public Pig2Thread(String pigName) {
        super(pigName, MATERIAL);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(MATERIAL.getComplexity() * 500L);
            System.out.println(getPigName() + "'s " + MATERIAL.getName() + " house has been built!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
