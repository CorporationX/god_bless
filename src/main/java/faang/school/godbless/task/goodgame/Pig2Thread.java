package faang.school.godbless.task.goodgame;

public class Pig2Thread extends PigThread {
    public Pig2Thread(String pigName) {
        super(pigName, MaterialType.MATCH);
    }

    @Override
    public void buildHouse() throws InterruptedException {
        System.out.println("Building a " + getMaterial().name() + " house for " + getPigName() + "...");
        sleep(5000);
        System.out.println("The " + getMaterial().name() + " house for " + getPigName() + " was successfully built");
    }
}
