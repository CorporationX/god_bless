package school.faang.task50236;

public class Main {
    public static void main(String[] args) {
        Battle battle = new Battle();

        Robot c3po = new Robot("C-3PO", 4, 8);
        Robot r2d2 = new Robot("R2-D2", 5, 7);

        battle.fight(r2d2, c3po).join();
    }
}
