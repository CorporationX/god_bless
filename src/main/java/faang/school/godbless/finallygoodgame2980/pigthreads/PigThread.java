package faang.school.godbless.finallygoodgame2980.pigthreads;

import lombok.Getter;

@Getter
public class PigThread extends Thread {
    private String pigName;
    private String material;
    private long timeToBuild;

    protected PigThread(String pigName, String material, long timeToBuild) {
        this.pigName = pigName;
        this.material = material;
        this.timeToBuild = timeToBuild;
    }
    @Override
    public void run() {
        System.out.printf("%s is building a house out of %ss%n", this.getPigName(), this.getMaterial());
        try {
            Thread.sleep(this.getTimeToBuild());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s has built his house%n", this.getPigName());
    }
}
