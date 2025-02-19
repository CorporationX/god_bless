package school.faang.chores;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;

import java.util.logging.Level;
import java.util.logging.Logger;

@Getter
@AllArgsConstructor
public class Chore implements Runnable {
    private final String title;
    private static final Logger LOGGER = Logger.getLogger(Chore.class.getName());

    @SneakyThrows
    @Override
    public void run() {
        LOGGER.setLevel(Level.INFO);
        LOGGER.info(Thread.currentThread().getName() + " is doing " + getTitle());
        Thread.sleep(1000);
    }
}
