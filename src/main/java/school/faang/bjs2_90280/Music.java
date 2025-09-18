package school.faang.bjs2_90280;

public class Music {
    public static void main(String[] args) {
        Player player = new Player();

        Thread user1 = new Thread(() -> {
            player.play();
            player.pause();
            player.play();
            player.skip();
            player.skip();
            player.previous();
            player.getStatus();
        }, "User1");

        Thread user2 = new Thread(() -> {
            player.play();
            player.pause();
            player.skip();
            player.play();
            player.skip();
            player.previous();
            player.getStatus();
        }, "User2");

        user1.start();
        user2.start();

        try {
            user1.join();
            user2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("Основной поток прерван");
        }

        System.out.println("Все пользователи завершили действия с плеером");
    }
}
