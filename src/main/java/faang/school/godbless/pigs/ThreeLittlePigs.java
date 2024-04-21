package faang.school.godbless.pigs;

public class ThreeLittlePigs {
    public static void main(String[] args) {
        Pig1Thread pig1 = new Pig1Thread("Nif-Nif", "Солома");
        Pig2Thread pig2 = new Pig2Thread("Nuf-Nuf", "Палки");
        Pig3Thread pig3 = new Pig3Thread("Naf-Naf", "Кирпичи");

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

        System.out.println("Game over!");
    }
}
