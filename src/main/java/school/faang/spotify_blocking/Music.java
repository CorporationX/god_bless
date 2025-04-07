package school.faang.spotify_blocking;

public class Music {
    public static void main(String[] args) {
        //On the exact one object!!!
        Player playerForTwo = new Player();
        Thread thread1 = new Thread(() -> playerForTwo.play());
        Thread thread2 = new Thread(() -> playerForTwo.play());
        thread1.start();
        thread2.start();
    }
}
