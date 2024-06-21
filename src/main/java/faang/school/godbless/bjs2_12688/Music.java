package faang.school.godbless.bjs2_12688;

import java.util.List;

public class Music {

  public static void main(String[] args) {

    List<String> listMusic = List.of("Metallica:Else Matters",
        "Metallica:Enter The Sandman", "Metallica:For Whom The Bell Tolls",
        "Metallica:Fade to Black", "Metallica:One");

    Player player = new Player(listMusic);

    List<Thread> threads = List.of(new Thread(player::play),
        new Thread(player::pause),
        new Thread(player::skip),
        new Thread(player::previous));

    threads.forEach(Thread::start);

  }

}
