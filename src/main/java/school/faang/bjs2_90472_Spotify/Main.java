package school.faang.bjs2_90472_Spotify;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        List<Thread> users = new ArrayList<>();

        for (int i = 0; i < 4; i++) {
            Thread user = new Thread()
        }
        Thread user1 = new Thread(player::play);
        user1.start();

        Thread user2 = new Thread(player::pause);
        user2.start();

        Thread user3 = new Thread(player::skip);
        user3.start();

        Thread user4 = new Thread(player::previous);
        user4.start();
    }
}
