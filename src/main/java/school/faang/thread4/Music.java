package school.faang.thread4;

public class Music {
    public static void main(String[] args) {

        Player spotifyMusic = new Player();

        Thread userAmerican = new Thread(() -> spotifyMusic.play());
        Thread userRussian = new Thread(() -> spotifyMusic.pause());
        Thread userEuropean = new Thread(() -> spotifyMusic.skip());
        Thread userAsian = new Thread(() -> spotifyMusic.previous());

        userAmerican.start();
        userRussian.start();
        userEuropean.start();
        userAsian.start();


    }
}
