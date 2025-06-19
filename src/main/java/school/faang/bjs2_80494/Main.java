package school.faang.bjs2_80494;

public class Main {
    public static void main(String[] args) {
        Droid r2t2 = new Droid("R2T2");
        Droid t2x2 = new Droid("T2X2");
        Droid bmx = new Droid("BMX");

        String greeting = "hey, my black bro";
        String farewell = "Good luck, man";
        int key1 = 5;
        int key2 = 2;

        r2t2.sendMessage(greeting, key2, t2x2);

        t2x2.sendMessage(farewell, key1, r2t2);

        bmx.sendMessage("This mission is failed", key1, t2x2);

    }
}
