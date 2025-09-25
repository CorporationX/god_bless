package bjs2_90135;

public class TamagotchiVlad {
    private final String name;
    private String state = "нейтральное";

    public TamagotchiVlad(String name) {
        this.name = name;
    }

    public synchronized void feed() {
        state = "сыт";
        System.out.println(name + " ест. Состояние: " + state);
    }

    public synchronized void play() {
        state = "весел";
        System.out.println(name + " играет. Состояние: " + state);
    }

    public synchronized void clean() {
        state = "чист";
        System.out.println(name + " чистится. Состояние: " + state);
    }

    public synchronized void sleep() {
        state = "спит";
        System.out.println(name + " спит. Состояние: " + state);
    }

    @Override
    public String toString() {
        return name;
    }
}