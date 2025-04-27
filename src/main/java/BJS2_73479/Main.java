package BJS2_73479;

public class Main {
    public static void main(String[] args) {
        Boss boss = new Boss(3);

        Player swordsman = new Player("Swordsman");
        Player archer = new Player("Archer");
        Player magician = new Player("Magician");
        Player warlock = new Player("Warlock");

        Thread thread1 = new Thread(() -> swordsman.doBattle(boss));
        Thread thread2 = new Thread(() -> archer.doBattle(boss));
        Thread thread3 = new Thread(() -> magician.doBattle(boss));
        Thread thread4 = new Thread(() -> warlock.doBattle(boss));

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
