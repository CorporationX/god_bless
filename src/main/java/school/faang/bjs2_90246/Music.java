package school.faang.bjs2_90246;

import lombok.SneakyThrows;

public class Music {
    @SneakyThrows
    public static void main(String[] args) {
        Player player = new Player();
        Thread t1 = new Thread(player::play);
        Thread t2 = new Thread(player::pause);
        Thread t3 = new Thread(player::skip);
        Thread t4 = new Thread(player::previous);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
