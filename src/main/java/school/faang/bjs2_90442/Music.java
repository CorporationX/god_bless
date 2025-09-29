package school.faang.bjs2_90442;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Thread alice = new Thread(() -> {
            player.play();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.skip();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.pause();
        },  "Alice");
        alice.start();
        Thread misha = new Thread(() -> player.pause(), "Misha");
        misha.start();
        Thread liza = new Thread(() -> player.skip(), "Liza");
        liza.start();
        Thread lena = new Thread(() -> player.previous(), "Lena");
        lena.start();

        try {
            alice.join();
            misha.join();
            liza.join();
            lena.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
