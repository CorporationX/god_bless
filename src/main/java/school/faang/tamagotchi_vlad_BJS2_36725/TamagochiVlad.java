package school.faang.tamagotchi_vlad_BJS2_36725;

public class TamagochiVlad {
    public static final int RENEW_STATE = 3000;

    private String name;
    private boolean isNotHungry;
    private boolean isFunny;
    private boolean isClean;
    private boolean isNotTired;

    public TamagochiVlad(String name) {
        this.name = name;
    }

    public synchronized void feed() {
        System.out.println(name + " is eating");
        isNotHungry = true;
        System.out.printf(name + " is not hungry - %s\n", isNotHungry);
        renewState();
        isNotHungry = false;
    }

    public synchronized void play() {
        System.out.println(name + " is playing");
        isFunny = true;
        System.out.printf(name + " is funny - %s\n", isFunny);
        renewState();
        isFunny = false;
    }

    public synchronized void clean() {
        System.out.println(name + " take shower");
        isClean = true;
        System.out.printf(name + " is clean - %s\n", isClean);
        renewState();
        isClean = false;
    }

    public synchronized void sleep() {
        System.out.println(name + " is sleeping");
        isNotTired = true;
        System.out.printf(name + " is not tired - %s\n", isNotTired);
        renewState();
        isNotTired = false;
    }

    private void renewState() {
        try {
            Thread.sleep(RENEW_STATE);
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
