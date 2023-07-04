package faang.school.godbless.Sprint4.Task_4_GoodGame;

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

    private String getMaterialAsString(int material) {
        switch (material) {
            case 1:
                return "соломы";
            case 2:
                return "палок";
            case 3:
                return "кирпичей";
            default:
                return "неизвестного материала";
        }
    }

    @Override
    public void run() {
        System.out.println(getPigName() + " начал строить дом из " + getMaterialAsString(material));
        try {
            Thread.sleep(getMaterial() * 2000L);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(getPigName() + " построил дом из " + getMaterialAsString(material));
    }
}

