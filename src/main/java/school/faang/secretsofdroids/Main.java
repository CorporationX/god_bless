package school.faang.secretsofdroids;

public class Main {
    public static void main(String[] args) {
        Droid robot1 = new Droid("robotPetya");
        Droid robot2 = new Droid("robotVasya");
        Droid robot3 = new Droid("robotBoris");

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        robot1.sendMessage(robot2, message1, 3);
        robot2.sendMessage(robot1, message2, encryptionKey2);
        robot3.sendMessage(robot2, "The mission is complete.", encryptionKey1);

    }
}