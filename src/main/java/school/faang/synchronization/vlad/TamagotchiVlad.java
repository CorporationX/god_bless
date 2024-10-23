package school.faang.synchronization.vlad;

public class TamagotchiVlad {
    private String state;
    private String name;

    public TamagotchiVlad(String name) {
        this.name = name;
    }

    public synchronized void feed() {
        state = "full";
        System.out.println(name + " is eating");
        System.out.println(name + " is " + state);
    }

    public synchronized void play() {
        state = "cheerful";
        System.out.println(name + " is playing");
        System.out.println(name + " is " + state);
    }

    public synchronized void clean() {
        state = "clean";
        System.out.println(name + " is cleaning");
        System.out.println(name + " is " + state);
    }

    public synchronized void sleep() {
        state = "tired";
        System.out.println("Vlad is sleeping");
        System.out.println(name + " is " + state);
    }

}
