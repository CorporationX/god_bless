package school.faang.BJS2_37217;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Music {
    private static final Logger LOGGER = Logger.getLogger(Music.class.getName());
    public static void main(String[] args) {
        Player player = new Player();
        Thread firstUser = new Thread(player::play);
        Thread secondUser = new Thread(player::pause);
        Thread thirdUser = new Thread(player::skip);
        Thread fourthUser = new Thread(player::previous);

        firstUser.start();
        secondUser.start();
        thirdUser.start();
        fourthUser.start();

        try {
            firstUser.join();
            secondUser.join();
            thirdUser.join();
            fourthUser.join();
            LOGGER.log(Level.INFO,"Все потоки завершены");
        } catch (InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Ошибка при завершении потока", e);
        }
    }
}
