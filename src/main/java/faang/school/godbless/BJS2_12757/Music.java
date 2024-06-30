package faang.school.godbless.BJS2_12757;

public class Music {
    public static void main(String[] args){
        Player player = new Player();

        Thread playThread = new Thread(() ->
                player.play());

        Thread pauseThread = new Thread(() ->
                player.pause());

        Thread skipThread = new Thread(() ->
                player.skip());

        Thread previosThread = new Thread(() ->
                player.previous());

        playThread.start();
        pauseThread.start();
        skipThread.start();
        previosThread.start();
    }
}
