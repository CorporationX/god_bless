package faang.school.godbless.spotify;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> musicList = List.of("Numb", "Bleed it out", "Bad Boys", "Rock it");
        Player player = new Player(musicList.get(0), musicList);
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
