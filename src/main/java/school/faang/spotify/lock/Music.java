package school.faang.spotify.lock;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread[] users = {new Thread(() -> player.play()),
                          new Thread(() -> player.pause()),
                          new Thread(() -> player.skip()),
                          new Thread(() -> player.previous())};

        for (Thread user : users) {
            user.start();
        }
    }
}
