package faang.school.godbless.FinallyNormalGame;

public class ThreeLittlePigs {
    public static void main(String[] args) throws InterruptedException {
        Pig1Thread pig1 = new Pig1Thread("Naf-Naf");
        Pig2Thread pig2 = new Pig2Thread("Nif-Nif");
        Pig3Thread pig3 = new Pig3Thread("Nuf-Nuf");

        pig1.start();
        pig2.start();
        pig3.start();

        pig1.join();
        pig2.join();
        pig3.join();

        System.out.println("Game over!");
    }
}
