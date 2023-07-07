package faang.school.godbless.banSpotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread firstThread = new Thread(player::play);
        Thread secondThread = new Thread(player::pause);
        Thread thirdThread = new Thread(player::skip);
        Thread fourthThread = new Thread(player::previous);

        firstThread.start();
        secondThread.start();
        thirdThread.start();
        fourthThread.start();
    }
}
