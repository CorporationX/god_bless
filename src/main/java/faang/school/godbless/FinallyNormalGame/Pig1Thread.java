package faang.school.godbless.FinallyNormalGame;

public class Pig1Thread extends PigThread {
    private static final Material MATERIAL = new Material("Straw", 20);

    public Pig1Thread(String pigName) {
        super(pigName, MATERIAL);
    }

    @Override
    public void run() {
        try {
            Thread.sleep(MATERIAL.getComplexity() * 1000L);
            System.out.println(getPigName() + "'s " + MATERIAL.getName() + " house has been built!");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
