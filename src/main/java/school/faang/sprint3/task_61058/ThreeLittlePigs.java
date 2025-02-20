package school.faang.sprint3.task_61058;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        Pig1Thread nif = new Pig1Thread();
        Pig2Thread nuf = new Pig2Thread();
        Pig3Thread naf = new Pig3Thread();

        nif.start();
        nuf.start();
        naf.start();

        try {
            nif.join();
            nuf.join();
            naf.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("The game is over!");
    }
}
