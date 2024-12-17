package school.faang.sprint3.bjs_47700;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        PigThread pig1 = new Pig1Thread("Ниф-Ниф", "солома");
        PigThread pig2 = new Pig2Thread("Нуф-Нуф", "палки");
        PigThread pig3 = new Pig3Thread("Наф-Наф", "кирпичи");

        pig1.start();
        pig2.start();
        pig3.start();

        pig1.join();
        pig2.join();
        pig3.join();

        System.out.println("Игра завершена!");
    }
}
