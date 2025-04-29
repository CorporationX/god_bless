package school.faang.multithreading.synchronization.bjs2_73252.spotify;

public class Music {
    public static void main(String[] args) {
        new Thread(Player::play).start();
        new Thread(Player::pause).start();
        new Thread(Player::pause).start();
        new Thread(Player::skip).start();
        new Thread(Player::previous).start();
        new Thread(Player::play).start();
        new Thread(Player::play).start();
        new Thread(Player::skip).start();
    }
}
