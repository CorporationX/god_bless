package faang.school.godbless.module1.sprint3.task8;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Player player = new Player();
        
        Thread threadFirst = new Thread(player::play);
        threadFirst.start();
        Thread threadSecond = new Thread(player::pause);
        threadSecond.start();
        Thread threadThird = new Thread(player::previous);
        threadThird.start();
        Thread threadFourth = new Thread(player::skip);
        threadFourth.start();

        threadFirst.join();
        threadSecond.join();
        threadThird.join();
        threadFourth.join();

    }
}
