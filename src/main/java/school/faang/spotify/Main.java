package school.faang.spotify;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Music music = new Music();

        for (Thread thread : music.getUserthreads()) {
            thread.start();
        }
    }
}