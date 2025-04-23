package school.faang.stream3.synchronization.spotify;

import lombok.Getter;

@Getter
public class User {
    private String name;
    private Player player;


    public User(String name) {
        this.name = name;
    }

    public void startNewPlayer() {
        player = new Player(100);
        player.getUserGroup().add(this);
    }

    public void joinPlayer(Player player) {
        this.player = player;
        player.getUserGroup().add(this);
    }

    public void play() {
        player.play();
    }

    public void pause() {
        player.pause();
    }

    public void skip() {
        player.skip();
    }

    public void previous() {
        player.previous();
    }

    public void showNextSongs() {
        player.showNextSongs(10);
    }
}
