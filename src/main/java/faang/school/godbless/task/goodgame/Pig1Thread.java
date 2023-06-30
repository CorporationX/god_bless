package faang.school.godbless.task.goodgame;

public class Pig1Thread extends PigThread {

    public Pig1Thread(String pigName) {
        super(pigName, MaterialType.HAY);
    }

    @Override
    public void buildHouse() throws InterruptedException {
        System.out.println("Building a " + getMaterial().name() + " house for " + getPigName() + "...");
        sleep(2000);
        System.out.println("The " + getMaterial().name() + " house for " + getPigName() + " was successfully built");
    }
}
