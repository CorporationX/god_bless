package school.faang.bjs2_87401;

public class Main {
    public static void main(String[] args) {

        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid f4pz = new Droid("F4PZ");

        String mes1 = "Join the Rebellion!!!";
        String mes2 = "The Death Star is operational!";

        r2d2.sendMessage(c3po, mes1, 3);
        c3po.sendMessage(f4pz, mes2, 7);
    }
}
