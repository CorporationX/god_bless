package school.faang.sprint_2.droids_secrets;

public class Main {
    public static void main(String[] args) {
        Droid c3po = new Droid("C3PO");
        Droid r2d2 = new Droid("R2D2");

        c3po.sendMessageTo(r2d2, "Hi! How are you?", 9);
        r2d2.sendMessageTo(c3po, "I'm fine, thx! U?", 2);
    }
}
