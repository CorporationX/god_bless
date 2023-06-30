package faang.school.godbless.task.goodgame;

public class Pig3Thread extends PigThread {
    public Pig3Thread(String pigName) {
        super(pigName, MaterialType.BRICK);
    }

    @Override
    public void buildHouse() throws InterruptedException {
        System.out.println("Building a " + getMaterial().name() + " house for " + getPigName() + "...");
        sleep(8000);
        System.out.println("The " + getMaterial().name() + " house for " + getPigName() + " was successfully built");
    }
}
