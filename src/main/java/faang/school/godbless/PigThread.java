package faang.school.godbless;

public class PigThread extends Thread{
    private String pigName;
    private int material;

    public PigThread(String pigName, int material) {
        this.pigName = pigName;
        this.material = material;
    }

    @Override
    public void run() {}

    public void buildHouse(String materialName) {
        System.out.println(pigName + " начинает строить дом из " + materialName);
        try {
            Thread.sleep(2000);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(pigName + " завершил строительство дома из " + materialName);
    }
}
