package faang.school.godbless.task;

import java.util.List;

public class Music {
    public static void main(String[] args) {
        Player player = new Player(List.of(
                "Rick Astley - Never Gonna Give You Up",
                "Beatles - Yesterday",
                "Zamay - Zamay",
                "Peach Pit - Peach Pit",
                "Placebo - Where is my mind"
        ));

        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}
