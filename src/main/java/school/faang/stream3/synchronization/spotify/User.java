package school.faang.stream3.synchronization.spotify;

import lombok.Getter;

@Getter
public class User {
    private static final int LIST_SIZE = 100;
    private String name;
    private Player player;

    public User(String name) {
        this.name = name;
    }

    public void startNewPlayer() {
        player = new Player(LIST_SIZE);
        player.getUserGroup().add(this);
    }

    public void joinPlayer(Player player) {
        this.player = player;
        player.getUserGroup().add(this);
    }
}
