package school.faang.broforce;

import lombok.Data;

@Data
public class Player {
    private String name;
    private int live;
    private int score;

    public Player(String name, int live) {
        this.name = name;
        this.live = live;
    }

    public void play(Game game) {
        game.updateGameProcess();
    }
}
