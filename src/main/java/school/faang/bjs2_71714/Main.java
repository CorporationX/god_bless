package school.faang.bjs2_71714;

public class Main {
    public static void main(String[] args) {
        Droid c3po = new Droid();
        Droid r2d2 = new Droid();

        c3po.sendMessage(r2d2, "Join the Rebellion!", 3);
        c3po.sendMessage(r2d2, "Join the Rebellion!", 4);
        c3po.sendMessage(r2d2, "Join the Rebellion!", 5);

    }
}
