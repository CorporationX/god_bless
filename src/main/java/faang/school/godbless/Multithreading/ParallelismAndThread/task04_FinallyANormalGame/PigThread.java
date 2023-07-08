package faang.school.godbless.Multithreading.ParallelismAndThread.task04_FinallyANormalGame;

public abstract class PigThread extends Thread {
    private String pigName;
    private String material;

    public PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }

    protected void buildHome(long time) {
        System.out.println(this.getPigName() + " started building a house out of " + this.getMaterial());
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public abstract void buildHome();

    public synchronized void start() {
        buildHome();
    }

    public String getMaterial() {
        return material;
    }

    public String getPigName() {
        return pigName;
    }


}
