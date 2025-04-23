package school.faang.bjs273190;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread firstStartThread = new Thread(player::play);
        firstStartThread.start();

        Thread secondStartThread = new Thread(player::play);
        secondStartThread.start();

        Thread skipThread = new Thread(player::skip);
        skipThread.start();

        Thread prevTread = new Thread(player::previous);
        prevTread.start();

        Thread stopThread = new Thread(player::pause);
        stopThread.start();
    }
}
