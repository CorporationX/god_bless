package faang.school.godbless.spring_4.finally_normal_game;

public abstract class PigThread extends Thread {
    private String pigName;
    private String material;

    public PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.printf("%s builds home from %s \n", getPigName(), getMaterial());
    }

    public String getPigName() {
        return pigName;
    }

    public void setPigName(String pigName) {
        this.pigName = pigName;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
