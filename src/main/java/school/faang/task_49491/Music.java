package school.faang.task_49491;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();
        var play = new Thread(player::play);
        play.start();
        var pause = new Thread(player::pause);
        pause.start();
        var skip = new Thread(player::skip);
        skip.start();
        var previous = new Thread(player::previous);
        previous.start();
    }
}
