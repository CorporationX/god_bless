package school.faang.bjs2_80117;

public class Main {
    private static String originalMessage = "May the Force be with you!";
    private static int key = 3;

    public static void main(String[] args) {
        Droid r2d2 = new Droid();
        Droid c3po = new Droid();

        r2d2.sendMessage(c3po, originalMessage, key);
    }
}
