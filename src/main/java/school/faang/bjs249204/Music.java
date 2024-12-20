package school.faang.bjs249204;

public class Music {
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

        member1.start();
        member2.start();
        member3.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(player.getIsPlaying());
    }
}
