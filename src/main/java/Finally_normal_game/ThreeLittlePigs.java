package Finally_normal_game;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        PigThread pig1 = new Pig1Thread("Ниф-Ниф",1);
        PigThread pig2 = new Pig2Thread("Нуф-Нуф",2);
        PigThread pig3 = new Pig3Thread("Наф-Наф",3);

        pig1.start();
        pig2.start();
        pig3.start();

        try {
            pig1.join();
            pig2.join();
            pig3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Game over");
    }
}
