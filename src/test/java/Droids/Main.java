package Droids;

public class Main {
    public static void main(String[] args) {
        Droid id1 = new Droid("Droid");
        Droid id2 = new Droid("Undroid");
        Droid id3 = new Droid("Moondroid");
        String message1 = "How far is it to Mars?";
        String message2 = "I don’t know... We don’t fly there";
        int key1 = 2;
        int key2 = 5;
        id1.sendMessage(message1, key1, id2);
        id2.sendMessage(message2, key2, id1);


    }
}
