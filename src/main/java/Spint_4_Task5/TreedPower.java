package Spint_4_Task5;

import lombok.Data;
import lombok.SneakyThrows;

@Data
public class TreedPower implements Runnable {
    private Unit entity;
    private int power;

    public TreedPower(Unit entity) {
        this.entity = entity;
    }


    @SneakyThrows
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " run");
        this.power = entity.getPower();
        Thread.sleep(5000);

    }
}
