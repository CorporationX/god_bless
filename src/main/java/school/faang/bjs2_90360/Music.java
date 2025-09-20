package school.faang.bjs2_90360;

public class Music {
    public static void main(String[] args) {
        Player playerHub = new Player();

        Thread firstListener = new Thread(playerHub::play, "слушатель 1");
        firstListener.start();

        Thread secondListener = new Thread(playerHub::pause, "слушатель 2");
        secondListener.start();

        Thread thirdListener = new Thread(playerHub::skip, "слушатель 3");
        thirdListener.start();

        Thread fourthListener = new Thread(playerHub::previous, "слушатель 4");
        fourthListener.start();
    }
}
