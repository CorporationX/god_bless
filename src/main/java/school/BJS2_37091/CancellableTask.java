package school.BJS2_37091;

import lombok.Setter;
import java.util.concurrent.ScheduledFuture;

public class CancellableTask implements Runnable {
    private Player player;
    private Game game;
    @Setter
    private ScheduledFuture<?> future;

    public CancellableTask(Player player, Game game) {
        this.player = player;
        this.game = game;
    }

    @Override
    public void run() {
        boolean result = game.update(player);
        if (result) {
            future.cancel(false);
        }
    }

}

