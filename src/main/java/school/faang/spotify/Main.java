package school.faang.spotify;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Music music = new Music();

        music.addThread();

        for (Thread thread : music.getThreads()) {
            thread.start();
        }
    }
}