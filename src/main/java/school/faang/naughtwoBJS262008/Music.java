package school.faang.naughtwoBJS262008;

public class Music {
    public static void main(String[] args) {
        Player player = new Player(false);

        Thread userOne = new Thread(player::skip);
        Thread userTwo = new Thread(player::play);
        Thread userThree = new Thread(player::pause);
        Thread userFour = new Thread(player::previous);
        userOne.start();
        userTwo.start();
        userThree.start();
        userFour.start();
    }
}
