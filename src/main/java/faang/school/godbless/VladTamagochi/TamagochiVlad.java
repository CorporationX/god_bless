package faang.school.godbless.VladTamagochi;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TamagochiVlad {
    public static final int MAX_STAT = 100;
    private static final int STAT_INCREASE = 10;
    private String name;
    private int hunger;
    private int cleanse;
    private int stamina;
    private int happiness;

    public synchronized void feedVlad() {
        if (hunger + STAT_INCREASE > MAX_STAT) {
            hunger = MAX_STAT;
        } else {
            hunger += STAT_INCREASE;
        }
        printVladInfo();
    }

    public synchronized void cleanseVlad() {
        if (cleanse + STAT_INCREASE > MAX_STAT) {
            cleanse = MAX_STAT;
        } else {
            cleanse += STAT_INCREASE;
        }
        printVladInfo();
    }

    public synchronized void restVlad() {
        if (stamina + STAT_INCREASE > MAX_STAT) {
            stamina = MAX_STAT;
        } else {
            stamina += STAT_INCREASE;
        }
        printVladInfo();
    }

    public synchronized void makeHappyVlad() {
        if (happiness + STAT_INCREASE > MAX_STAT) {
            happiness = MAX_STAT;
        } else {
            happiness += STAT_INCREASE;
        }
        printVladInfo();
    }
    public void printVladInfo()
    {
        System.out.println(name + "\t" + hunger + "\t" + cleanse + "\t" + stamina + "\t" + happiness);
    }
}
