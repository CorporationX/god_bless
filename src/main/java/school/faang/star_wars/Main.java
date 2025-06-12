package school.faang.star_wars;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO");
        Droid bb8 = new Droid("BB-8");

        r2d2.sendMessage(c3po, "Hello C3PO, I'm R2D2!", 2);
        r2d2.sendMessage(bb8, "Hello BB-8, I'm R2D2!", 3);
        c3po.sendMessage(r2d2, "Hello R2D2, I'm C3PO!", 4);
        bb8.sendMessage(r2d2, "Hello R2D2, I'm BB-8!", 5);
    }
}
