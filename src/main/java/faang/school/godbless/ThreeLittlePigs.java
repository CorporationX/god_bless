package faang.school.godbless;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        PigThread firstPig = new Pig1Thread("Ниф-Ниф", "солома");
        PigThread secondPig = new Pig2Thread("Нуф-Нуф", "палки");
        PigThread ThirdPig = new Pig3Thread("Наф-Наф", "кирпичи");
        firstPig.start();
        secondPig.start();
        ThirdPig.start();

        firstPig.join();
        secondPig.join();
        ThirdPig.join();

        System.out.println("Game over");
    }
}
