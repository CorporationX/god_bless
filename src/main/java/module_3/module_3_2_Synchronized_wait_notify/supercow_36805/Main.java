package module_3.module_3_2_Synchronized_wait_notify.supercow_36805;

public class Main {
    private final static int THREAD_POOL_SIZE = 3;

    public static void main(String[] args) {
        Boss boss = new Boss(THREAD_POOL_SIZE);
        String[] names = {"Вася", "Петя", "Даня", "Маша", "Олег"};
        Thread[] threads = new Thread[names.length];

        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            threads[i] = new Thread(() -> new Player(name).startBattle(boss));
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }
}
