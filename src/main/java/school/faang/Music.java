package school.faang;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread userFirst;
        userFirst = new Thread(() -> {
            player.play();
        });

        Thread userSecond;
        userSecond = new Thread(() -> {
            player.skip();
        });

        Thread userThirth;
        userThirth = new Thread(() -> {
            player.pause();
        });

        Thread userFour;
        userFour = new Thread(() -> {
            player.previous();
        });

        userFirst.start();
        userSecond.start();
        userThirth.start();
        userFour.start();

        try {
            userFirst.join();
            userSecond.join();
            userThirth.join();
            userFour.join();
        } catch (InterruptedException e) {
            e.printStackTrace();

        }
    }
}
