package school.faang.task_46208;

public class Main {
    public static void main(String[] args) {

        Droid droid = new Droid("R2D2");
        Droid droid1 = new Droid("C3PO");
        Droid droid2 = new Droid("BB-8");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        droid.sendMessage(message1, encryptionKey1, droid);

        droid1.sendMessage(message2, encryptionKey2, droid1);

        droid2.sendMessage("The mission is complete.", encryptionKey1, droid2);
    }
}

