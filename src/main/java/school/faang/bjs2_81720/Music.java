package school.faang.bjs2_81720;

import java.util.List;

public class Music {
    private static Player musicPlayer = new Player();

    public static void main(String[] args) {
        List<Thread> treads = List.of(new Thread(musicPlayer::play),
                                      new Thread(musicPlayer::pause),
                                      new Thread(musicPlayer::skip),
                                      new Thread(musicPlayer::previous));

        treads.forEach(Thread::start);
    }
}
