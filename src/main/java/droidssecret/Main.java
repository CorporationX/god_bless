package droidssecret;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2-D2");
        Droid c3po = new Droid("C-3PO");

        int key = 3;

        r2d2.sendMessage("Hello, C-3PO!", key, c3po);
        c3po.sendMessage("Hi, R2-D2! Got your message.", key, r2d2);
    }
}
