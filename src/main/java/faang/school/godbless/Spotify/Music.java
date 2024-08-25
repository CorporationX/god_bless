package faang.school.godbless.Spotify;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player(new Music());
        List<Thread> list = List.of(new Thread(player::play), new Thread(player::skip), new Thread(player::skip)
                , new Thread(player::play), new Thread(player::previous)
                , new Thread(player::pause), new Thread(player::pause)
                , new Thread(player::previous), new Thread(player::previous));

        list.forEach(Thread::start);
    }
}
