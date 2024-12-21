package school.faang.task_49491;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        var play = new Thread(player::play);
        var pause = new Thread(player::pause);
        var skip = new Thread(player::skip);
        var previous = new Thread(player::previous);
        previous.start();
        play.start();
        pause.start();
        skip.start();
    }
}
