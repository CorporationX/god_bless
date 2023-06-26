package faang.school.godbless.sprint4.some.finallyNormalGame.classes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public abstract class PigThread extends Thread {
    private String pigName;
    private Material material;

    protected void buildHouse(long time) {
        System.out.println(this.getPigName() + " started building a house");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.getPigName() + " built a house " + this.getMaterial().toString());
    }

    public abstract void buildHouse();

    @Override
    public synchronized void start() {
        buildHouse();
    }
}
