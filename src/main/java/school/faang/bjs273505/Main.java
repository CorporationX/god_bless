package school.faang.bjs273505;

public class Main {
    public static void main(String[] args) {
        Boss oryx = new Boss("Oryx", 2);
        Player titan = new Player("Titan");
        Player warlock = new Player("Warlock");
        Player hunter = new Player("Hunter");

        Thread titanThread = new Thread(() -> titan.doBattle(oryx));
        titanThread.start();
        Thread warlockThread = new Thread(() -> warlock.doBattle(oryx));
        warlockThread.start();
        Thread hunterThread = new Thread(() -> hunter.doBattle(oryx));
        hunterThread.start();
    }
}
