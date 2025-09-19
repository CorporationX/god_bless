package school.faang.bjs2_90360;

public class Music {
    public static void main(String[] args) {
        Player playerHub = new Player();

        Thread firstListener = new Thread(playerHub::play, "слушатель 1");
        Thread secondListener = new Thread(playerHub::pause, "слушатель 2");
        Thread thirdListener = new Thread(playerHub::skip, "слушатель 3");
        Thread fourthListener = new Thread(playerHub::previous, "слушатель 4");

        firstListener.start();
        secondListener.start();
        thirdListener.start();
        fourthListener.start();
    }
}
