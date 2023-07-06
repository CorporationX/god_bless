package tamagochi_vlad;

public class TamagotchiVlad {
    private final String name;
    private boolean hungry;
    private boolean tired;
    private boolean dirty;

    public TamagotchiVlad(String name) {
        this.name = name;
    }

    public synchronized void feed() {
        if (hungry) {
            System.out.println(name + " has been fed");
            hungry = false;
        } else {
            System.out.println(name + " is not hungry");
        }
    }

    public synchronized void play() {
        if (tired) {
            System.out.println(name + " is too tired to play games");
        } else {
            System.out.println(name + " is playing");
            tired = true;
        }
    }

    public synchronized void clean() {
        if (dirty) {
            System.out.println(name + " took a shower");
            dirty = false;
        } else {
            System.out.println(name + " is not dirty");
        }
    }

    public synchronized void sleep() {
        if (tired) {
            System.out.println(name + " is sleeping");
            tired = false;
        } else {
            System.out.println(name + "is not tired");
        }
    }
}
