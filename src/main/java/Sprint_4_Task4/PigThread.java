package Sprint_4_Task4;

public class PigThread extends Thread{
    private String pigName;
    private String material;

    public PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }

    @Override
    public void run() {
        System.out.println(pigName + ": Построил дом из " + material);
    }
}
