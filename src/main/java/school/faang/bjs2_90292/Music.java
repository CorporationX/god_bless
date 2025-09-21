package school.faang.bjs2_90292;

public class Music {
    public static void main(String[] args) {

        new Thread(Player::pause).start();
        new Thread(Player::play).start();
        new Thread(Player::play).start();
        new Thread(Player::pause).start();
        new Thread(Player::previous).start();
        new Thread(Player::skip).start();
    }
}
