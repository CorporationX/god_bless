package tamagochi;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@EqualsAndHashCode
public class TamagochiVlad {
    private final int id;
    private boolean fed;
    private boolean played;
    private boolean cleaned;
    private boolean slept;

    public TamagochiVlad(int id) {
        this.id = id;
        fed = false;
        played = false;
        cleaned = false;
        slept = false;
    }

    public synchronized void feed() {
        log.info(String.format("Feeding Vlad #%d", id));
        fed = true;
    }

    public synchronized void play() {
        log.info(String.format("Playing with Vlad #%d", id));
        played = true;
    }

    public synchronized void clean() {
        log.info(String.format("Cleaning Vlad #%d", id));
        cleaned = true;
    }

    public synchronized void sleep() {
        log.info(String.format("Send Vlad #%d to sleep", id));
        slept = true;
    }

    public synchronized String getInfo() {
        return "\nVlad #" + id + ":\n" +
                "Fed: " + fed + "\n" +
                "Played: " + played + "\n" +
                "Cleaned: " + cleaned + "\n" +
                "Slept: " + slept;
    }
}
