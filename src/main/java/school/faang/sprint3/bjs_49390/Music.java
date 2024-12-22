package school.faang.sprint3.bjs_49390;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        Runnable[] commands = new Runnable[4];

        commands[0] = () -> player.play();
        commands[1] = () -> player.pause();
        commands[2] = () -> player.skip();
        commands[3] = () -> player.previous();

        for (int i = 0; i < commands.length; i++) {
            Thread thread = new Thread(commands[i]);
            thread.start();
        }
    }
}
