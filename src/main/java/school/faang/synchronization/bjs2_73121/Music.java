package school.faang.synchronization.bjs2_73121;

class Music {
    private static final Player player = new Player();

    public static void main(String[] args) {
        Thread thread1 = new Thread(player::play);
        thread1.start();
        Thread thread2 = new Thread(player::pause);
        thread2.start();
        Thread thread3 = new Thread(player::play);
        thread3.start();
        Thread thread4 = new Thread(player::skip);
        thread4.start();
        Thread thread8 = new Thread(player::skip);
        thread8.start();
        Thread thread5 = new Thread(player::previous);
        thread5.start();
        Thread thread6 = new Thread(player::pause);
        thread6.start();
        Thread thread7 = new Thread(player::skip);
        thread7.start();
    }
}
