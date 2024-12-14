package school.faang.task_46271;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        r2d2.sendMessage("Join the Rebellion!", 3, c3po);
        c3po.sendMessage("Join the Rebellion!", 7, bb8);
        bb8.sendMessage("Hello world!!!", 8, r2d2);
    }
}
