package school.faangSprint3.t20;

public class TamagotchiVlad {
    private final String name;
    private String state = "нейтральное";

    public TamagotchiVlad(String name) {
        this.name = name;
    }

    public synchronized void feed() {
        state = "сыт";
        System.out.println(name + " ест. Его состояние: " + state);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void play() {
        state = "весел";
        System.out.println(name + " играет. Его состояние: " + state);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void clean() {
        state = "чист";
        System.out.println(name + " чистится. Его состояние: " + state);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized void sleep() {
        state = "спит";
        System.out.println(name + " спит. Его состояние: " + state);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public String toString() {
        return name;
    }
}