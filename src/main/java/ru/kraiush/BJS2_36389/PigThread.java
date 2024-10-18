package ru.kraiush.BJS2_36389;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PigThread extends Thread {
    private String pigName;
    private String material;

    public void buildHouse(int delay) {
        System.out.println(getPigName() + " is building a house of " + getMaterial());
        try {
            Thread.sleep(delay);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(getPigName() + " has finished building a house of " + getMaterial());
    }
}
