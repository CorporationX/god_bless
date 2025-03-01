package school.faang.naughtwoBJS262008;

public class Music {
    public static void main(String[] args) {
        Player player = new Player(false);

        Thread userOne = new Thread(player::skip);
        userOne.start();
        Thread userTwo = new Thread(player::play);
        userTwo.start();
        Thread userThree = new Thread(player::pause);
        userThree.start();
        Thread userFour = new Thread(player::previous);
        userFour.start();

        try {
            userOne.join();
            userTwo.join();
            userThree.join();
            userFour.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
