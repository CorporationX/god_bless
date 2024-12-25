package school.faang.sprint_3.task_49398;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        List<Runnable> actions =
            List.of(player::play, player::pause, player::skip, player::previous);

        actions.forEach(thrd -> new Thread(thrd).start());
    }
}
