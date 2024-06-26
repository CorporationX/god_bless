package faang.school.godbless;

import faang.school.godbless.BJS212723.Player;

public class Application {

    public static void main(String[] args) {
        Player player = new Player();

        new Thread(player::play).start();
        new Thread(player::previous).start();
        new Thread(player::skip).start();
        new Thread(player::pause).start();
    }
}
