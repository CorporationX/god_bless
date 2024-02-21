package faang.school.godbless.spotifyblocking;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();


        for (int i = 0; i < 100; i++) {
            new Thread(player::play).start();
            new Thread(player::pause).start();
            new Thread(player::skip).start();
            new Thread(player::previous).start();
        }
    }

}
