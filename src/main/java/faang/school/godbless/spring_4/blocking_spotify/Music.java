package faang.school.godbless.spring_4.blocking_spotify;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        new Thread(player::play);
        new Thread(player::pause);
        new Thread(player::skip);
        new Thread(player::previous);

    }
}
