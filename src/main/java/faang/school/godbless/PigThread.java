package faang.school.godbless;

public class PigThread extends Thread {
    private String pigName;
    private int material;

    public PigThread(String pigName, int material) {
        this.pigName = pigName;
        this.material = material;
    }

    public String getPigName() {
        return pigName;
    }

    public int getMaterial() {
        return material;
    }

    @Override
    public void run() {
        try {
            System.out.println("Pig " + pigName + " start build house with " + getMaterialName(material));
            Thread.sleep(2000);
            System.out.println("Pig " + pigName + " has built the house with " + getMaterialName(material));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String getMaterialName(int material) {
        switch (material) {
            case 1:
                return "soloma";
            case 2:
                return "sticks";
            case 3:
                return "kirpichi";
            default:
                return "unknown";
        }
    }

}
