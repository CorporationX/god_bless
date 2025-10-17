package school.faang.stream3.player;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.function.BiConsumer;

public class PlayerUsersGenerator implements BiConsumer<PlayerAction, ExecutorService> {

    public static final List<PlayerAction> playerActions =
            List.of(PlayerAction.PLAY, PlayerAction.PAUSE, PlayerAction.SKIP, PlayerAction.PREVIOUS);
    private final Player player = new Player();

    @Override
    public void accept(PlayerAction action, ExecutorService executorService) {
        switch (action) {
            case PLAY -> executorService.execute(player::play);
            case PAUSE -> executorService.execute(player::pause);
            case PREVIOUS -> executorService.execute(player::previous);
            default -> executorService.execute(player::skip);
        }
    }
}
