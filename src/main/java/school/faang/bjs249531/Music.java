package school.faang.bjs249531;

public class Music {

    public static void main(String[] args) {
        Player player = new Player();
        Thread one = new Thread(() -> player.play());
        one.start();
        Thread two = new Thread(() -> player.pause());
        two.start();
        Thread three = new Thread(() -> player.skip());
        three.start();
        Thread four = new Thread(() -> player.previous());
        four.start();
    }

}
