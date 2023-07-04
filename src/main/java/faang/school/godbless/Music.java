package faang.school.godbless;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(player::play);
        Thread pauseThread = new Thread(player::pause);
        Thread skipThread = new Thread(player::skip);
        Thread previousThread = new Thread(player::previous);

        playThread.start();
        System.out.println("Is music paying: " + player.isPlaying());
        pauseThread.start();
        System.out.println("Is music paying: " + player.isPlaying());
        skipThread.start();
        System.out.println("Is music paying: " + player.isPlaying());
        previousThread.start();
        System.out.println("Is music paying: " + player.isPlaying());
    }
}
