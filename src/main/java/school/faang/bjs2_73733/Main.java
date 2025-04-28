package school.faang.bjs2_73733;

public class Main {
    private static final Boss SUPER_COW = new Boss(2);
    private static final Player gimli = new Player("Gimli");
    private static final Player legolas = new Player("Legolas");
    private static final Player frodo = new Player("Frodo");

    public static void main(String[] args) {
        new Thread(() -> gimli.doBattle(SUPER_COW), "GIMLI").start();
        new Thread(() -> legolas.doBattle(SUPER_COW), "LEGOLAS").start();
        new Thread(() -> frodo.doBattle(SUPER_COW), "FRODO").start();
    }
}
