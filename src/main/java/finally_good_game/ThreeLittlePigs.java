package finally_good_game;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        Pig1Thread nifNif = new Pig1Thread("nif nif", "straw");
        Pig2Thread nafNaf = new Pig2Thread("naf naf", "sticks");
        Pig3Thread nufNuf = new Pig3Thread("nuf nuf", "bricks");

        nifNif.start();
        nafNaf.start();
        nufNuf.start();

        try {
            nifNif.join();
            nafNaf.join();
            nufNuf.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Pigs built all house successfully");
    }
}
