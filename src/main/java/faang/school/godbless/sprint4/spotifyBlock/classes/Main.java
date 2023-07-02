package faang.school.godbless.sprint4.spotifyBlock.classes;

public class Main {
    public static void main(String[] args) {
        Player player = new Player();

        Thread play = new Thread(player::play);
        Thread pause = new Thread(player::pause);
        Thread skip = new Thread(player::skip);
        Thread pervious = new Thread(player::pervious);

        play.start();
        pause.start();
        skip.start();
        pervious.start();

    }
}
