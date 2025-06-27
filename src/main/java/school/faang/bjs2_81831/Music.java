package school.faang.bjs2_81831;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread firstUser = new Thread(player::play, "firstUser");
        firstUser.start();

        Thread secondUser = new Thread(player::pause, "secondUser");
        secondUser.start();

        Thread thirdUser = new Thread(player::skip, "thirdUser");
        thirdUser.start();

        Thread fourthUser = new Thread(player::previous, "fourthUser");
        fourthUser.start();
    }
}
