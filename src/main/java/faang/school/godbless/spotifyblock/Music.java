package faang.school.godbless.spotifyblock;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread play = new Thread(player::play);
        Thread skip = new Thread(player::skip);
        Thread pause = new Thread(player::pause);
        Thread previous = new Thread(player::previous);

        play.start();
        skip.start();
        pause.start();
        previous.start();
    }
}
