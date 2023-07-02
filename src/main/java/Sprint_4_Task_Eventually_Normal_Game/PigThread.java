package Sprint_4_Task_Eventually_Normal_Game;

import lombok.SneakyThrows;

public class PigThread extends Thread{

    private String pigName;
    private String material;

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(1000);
        System.out.println(pigName + " строит дом из " + material);
    }

    public String getPigName() {
        return pigName;
    }

    public String getMaterial() {
        return material;
    }



    public PigThread(String pigName, String material) {
        this.pigName = pigName;
        this.material = material;
    }
}

