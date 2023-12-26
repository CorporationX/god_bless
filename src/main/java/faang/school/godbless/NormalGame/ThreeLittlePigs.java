package faang.school.godbless.NormalGame;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread pig1 = new Pig1Thread();
        PigThread pig2 = new Pig2Thread();
        PigThread pig3 = new Pig3Thread();

        pig1.start();
        pig2.start();
        pig3.start();

        try {
            pig1.join();
            pig2.join();
            pig3.join();
        } catch (InterruptedException e) {
            Thread.interrupted();
            System.out.println("Ошибка выполнения");
        }

        System.out.println("Iгра завершена!");
    }
}
