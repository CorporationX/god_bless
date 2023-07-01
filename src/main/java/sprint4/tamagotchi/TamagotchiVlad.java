package sprint4.tamagotchi;

import lombok.Data;

@Data
public class TamagotchiVlad {
    private final Object lock = new Object();
    private static final int MAX_PARAMETER = 100;
    private static final int MIN_PARAMETER = 0;
    private final int factoryNumber;
    private int satiety = 60;
    private int fun = 60;
    private int purity = 60;
    private int adolescence = 60;
    private boolean included = false;

    public TamagotchiVlad(int factoryNumber) {
        this.factoryNumber = factoryNumber;
    }

    public void start() {
        synchronized (lock) {
            included = true;
            while (included) {
                vladIsStarving();
                vladGetsBored();
                vladGetsDirty();
                vladGetsTired();
                stateOfVlad();
            }
        }
    }

    public synchronized void feed() {
        System.out.printf("You are feeding Vlad (fn: %d)\n", factoryNumber);
        satiety = MAX_PARAMETER;
    }

    public synchronized void play() {
        System.out.printf("You play with Vlad (fn: %d)\n", factoryNumber);
        fun = MAX_PARAMETER;
    }

    public synchronized void clean() {
        System.out.printf("You wash Vlad (fn: %d)\n", factoryNumber);
        purity = MAX_PARAMETER;
    }

    public synchronized void sleep() {
        System.out.printf("You put Vlad (fn: %d) to bed\n", factoryNumber);
        adolescence = MAX_PARAMETER;
    }

    public void turnOffForever() {
        included = false;
    }

    private void vladIsStarving() {
        satiety -= satiety == MIN_PARAMETER ? MIN_PARAMETER : 10;
        System.out.printf("Vlad (fn: %d) is starving\n", factoryNumber);
        waitForNextAction();
    }

    private void vladGetsBored() {
        fun -= fun == MIN_PARAMETER ? MIN_PARAMETER : 10;
        System.out.printf("Vlad (fn: %d) gets bored\n", factoryNumber);
        waitForNextAction();
    }

    private void vladGetsDirty() {
        purity -= purity == MIN_PARAMETER ? MIN_PARAMETER : 10;
        System.out.printf("Vlad (fn: %d) gets dirty\n", factoryNumber);
        waitForNextAction();
    }

    private void vladGetsTired() {
        adolescence -= adolescence == MIN_PARAMETER ? MIN_PARAMETER : 10;
        System.out.printf("Vlad (fn: %d) gets tired\n", factoryNumber);
        waitForNextAction();
    }

    private void stateOfVlad() {
        System.out.printf("Current State of the Vlad (fn: %d):\nSatiety: %d; Fun: %d; Purity: %d; Adolescence: %d\n",
                factoryNumber, satiety, fun, purity, adolescence);
        if (satiety == 0 && fun == 0 && purity == 0 && adolescence == 0) {
            System.out.printf("Vlad (fn: %d) left but promised to come back\n", factoryNumber);
            turnOffForever();
        }
        waitForNextAction();
    }

    private void waitForNextAction() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
