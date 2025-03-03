package school.faang.spotify_block;

public class Music {

    protected static String[] musics = {"Thriller", "Bohemian Rhapsody", "Smells like teen spirit", "Iron Man",
            "Master of Puppets", "Not like us", "FEIN", "Stronger", "Shape of you", "Blinding Lights"};
    protected static int songPlayingNow = 0;

    public static void main(String[] args) {
        Player player = new Player();
        Thread thread1 = new Thread(() -> player.play());
        Thread thread2 = new Thread(() -> player.skip());
        Thread thread3 = new Thread(() -> player.previous());
        thread1.start();
        thread2.start();
        thread3.start();
        Thread thread4 = new Thread(() -> player.pause());
        Thread thread5 = new Thread(() -> player.play());
        Thread thread6 = new Thread(() -> player.previous());
        thread4.start();
        thread5.start();
        thread6.start();
        Thread thread7 = new Thread(() -> player.play());
        Thread thread8 = new Thread(() -> player.skip());
        thread7.start();
        thread8.start();
        System.out.println("Music is playing now: " + musics[songPlayingNow]);
    }

}
