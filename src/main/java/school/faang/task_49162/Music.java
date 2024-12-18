package school.faang.task_49162;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        new Thread(player::play).start();
        new Thread(player::pause).start();
        new Thread(player::previous).start();
        new Thread(player::play).start();
        new Thread(player::skip).start();

    }
}
