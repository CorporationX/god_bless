package faang.school.godbless.synchronization.spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        new Thread(player::play).start();
        new Thread(player::pause).start();
        new Thread(player::skip).start();
        new Thread(player::previous).start();
    }
}
