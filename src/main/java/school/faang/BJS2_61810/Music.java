package school.faang.BJS2_61810;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Slf4j
public class Music {
    private static final Player player = new Player();
    private static final Map<Command, Runnable> commands = new HashMap<>();
    private static final Random random = new Random();
    private static final List<Thread> threads = new ArrayList<>();
    private static final int COMMAND_COUNT = 20;


    public static void main(String[] args) {

        commands.put(Command.PLAY, player::play);
        commands.put(Command.PAUSE, player::pause);
        commands.put(Command.SKIP, player::skip);
        commands.put(Command.PREVIOUS, player::previous);

        for (int i = 0; i < COMMAND_COUNT; i++) {
            Thread thread = new Thread(commands.get(getCommand()));
            threads.add(thread);
        }
        threads.forEach(Thread::start);
        log.info("Finishing processing commands...");
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            log.error(e.getMessage());
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
        log.info("Command processing is completed.");

    }

    private static Command getCommand() {
        Command[] commands = Command.values();
        return commands[random.nextInt(commands.length)];
    }
}
