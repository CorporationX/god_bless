package school.faang.synchronized__notify.bjs2_90328;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static school.faang.synchronized__notify.bjs2_90328.Utils.random;
import static school.faang.synchronized__notify.bjs2_90328.Utils.runAwaitAndShutdown;
import static school.faang.synchronized__notify.bjs2_90328.Utils.runWithThreadErrorHandling;

@Slf4j
public class Main {
    private static final int NUM_THREADS = 20;
    private static final int ROLE_OWNERSHIP_TIME_MS = 10000;
    public static List<String> listNameUsers = List.of(
            "byteforge",
            "codevoyager",
            "pixelranger",
            "neonterra",
            "quantumtrail",
            "bitnomad",
            "stack_scout",
            "data_harbor",
            "delta_coder",
            "echo_logic",
            "nova_script",
            "rusty_owl",
            "zero_prompt",
            "kilo_flux",
            "grid_runner",
            "cipher_wisp",
            "core_blend",
            "zen_cache",
            "quiet_kernel",
            "midnight_io"
    );

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        House house = new House();

        CheckedRunnable runTasks = () -> listNameUsers.stream()
                .map(nameUser -> (Runnable) () -> runWithThreadErrorHandling(() -> {
                    User user = new User(nameUser, house);
                    user.joinHouse();
                    Thread.sleep(Long.valueOf(random(ROLE_OWNERSHIP_TIME_MS)));
                    user.leaveHouse();
                })).forEach(executor::submit);

        runAwaitAndShutdown(executor, runTasks);
    }
}