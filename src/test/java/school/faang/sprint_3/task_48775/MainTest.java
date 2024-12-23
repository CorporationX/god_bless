package school.faang.sprint_3.task_48775;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

import java.time.Duration;

public class MainTest {

    @Test
    public void testMainExecution() {
        assertTimeoutPreemptively(Duration.ofMinutes(3), () -> {
            Main.main(new String[]{});
        });
    }
}
