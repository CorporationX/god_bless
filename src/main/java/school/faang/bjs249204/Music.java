package school.faang.bjs249204;

public class Music {

    public static final int SLEEP_MILLISECOND = 1000;

    public static void main(String[] args) {

        Player player = new Player();

        Thread member1 = new Thread(() -> {
            System.out.println("Member 1 is playing music");
            player.play();
        });

        Thread member2 = new Thread(() -> {
            System.out.println("Member 2 is skipped music");
            player.skip();
        });

        Thread member3 = new Thread(() -> {
            System.out.println("Member 3 is paused music");
            player.pause();
        });

        Thread[] threads = {member1, member2, member3};

        for (Thread thread : threads) {
            thread.start();
        }

        try {
            Thread.sleep(SLEEP_MILLISECOND);
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(player.getIsPlaying());
    }
}
