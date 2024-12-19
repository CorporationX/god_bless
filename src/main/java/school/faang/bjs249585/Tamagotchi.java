package school.faang.bjs249585;

public class Tamagotchi {

    public synchronized void feed() {
        System.out.println("Tamagochi " + Action.FEED.name());
    }

    public synchronized void play() {
        System.out.println("Tamagochi " + Action.PLAY.name());
    }

    public synchronized void clean() {
        System.out.println("Tamagochi " + Action.CLEAN.name());
    }

    public synchronized void sleep() {
        System.out.println("Tamagochi " + Action.SLEEP.name());
    }
}