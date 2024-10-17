package school.faangSprint3.t05;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread playThread = new Thread(() -> {
            while (true) {
                player.play();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread pauseThread = new Thread(() -> {
            while (true) {
                player.pause();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread skipThread = new Thread(() -> {
            while (true) {
                player.skip();
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread previousThread = new Thread(() -> {
            while (true) {
                player.previous();
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previousThread.start();
    }
}