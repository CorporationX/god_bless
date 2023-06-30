package tamagotchi_vlad;

public class TamagotchiVlad {
    private String name;
    private boolean fed;
    private boolean played;
    private boolean cleaned;
    private boolean sleeping;

    public String getName() {
        return name;
    }

    public TamagotchiVlad(String name) {
        this.name = name;
        fed = false;
        played = false;
        cleaned = false;
        sleeping = false;
    }

    public synchronized void feed() {
        if (sleeping) {
            System.out.println(name + " is sleeping now and can't be fed");
            return;
        }
        if (fed) {
            System.out.println(name + " has already been fed");
        } else {
            System.out.println(name + " is eating");
            fed = true;
            System.out.println(name + " has been fed");
        }
    }

    public synchronized void play() {
        if (sleeping) {
            System.out.println(name + " is sleeping now and can't play");
            return;
        }
        if (played) {
            System.out.println(name + " has already played");
        } else {
            System.out.println(name + " is playing");
            played = true;
            System.out.println(name + " has finished playing");
        }
    }

    public synchronized void clean() {
        if (sleeping) {
            System.out.println(name + " is sleeping now and can't be cleaned");
            return;
        }
        if (cleaned) {
            System.out.println(name + " has already been cleaned");
        } else {
            System.out.println(name + " is being cleaned");
            cleaned = true;
            System.out.println(name + " has been cleaned");
        }
    }

    public synchronized void sleep() {
        if (sleeping) {
            System.out.println(name + " is already sleeping");
        } else {
            System.out.println(name + " is going to sleep");
            sleeping = true;
            fed = false;
            played = false;
            cleaned = false;
            System.out.println(name + " is sleeping now");
        }
    }

    public synchronized void wakeUp() {
        if (sleeping) {
            System.out.println(name + " is waking up");
            sleeping = false;
            System.out.println(name + " awake now");
        } else {
            System.out.println(name + " is already awake");
        }
    }
}
