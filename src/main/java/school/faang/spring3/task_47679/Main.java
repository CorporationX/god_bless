package school.faang.spring3.task_47679;

public class Main {
    public static void main(String[] args) {
        PigThread pig1 = new PigThread1("Ниф-Ниф", "солома");
        PigThread pig2 = new PigThread2("Нуф-Нуф", "палки");
        PigThread pig3 = new PigThread3("Наф-Наф", "кирпичи");

        pig1.start();
        pig2.start();
        pig3.start();

        try {
            pig1.join();
            pig2.join();
            pig3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Игра завершена!");
    }
}
