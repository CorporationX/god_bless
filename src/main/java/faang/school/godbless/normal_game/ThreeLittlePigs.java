package faang.school.godbless.normal_game;

public class ThreeLittlePigs {

    public static void main(String[] args) {
        Pig1Thread nifNif = new Pig1Thread("Nif-Nif", 1);
        Pig2Thread nufNuf = new Pig2Thread("Nuf-Nuf", 2);
        Pig3Thread nafNaf = new Pig3Thread("Naf-Naf", 3);

        nifNif.start();
        nufNuf.start();
        nafNaf.start();

        try {
            nifNif.join();
            nufNuf.join();
            nafNaf.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Game over!");
    }
}
