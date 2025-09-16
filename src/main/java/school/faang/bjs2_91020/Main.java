package school.faang.bjs2_91020;

public class Main {
    public static void main(String[] args) {
        Droid droid1 = new Droid();

        String message = "Hello, World!";
        int key = 3;

        System.out.println("Original: " + message);

        String encrypted = droid1.encryptMessage(message, key);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = droid1.decryptMessage(encrypted, key);
        System.out.println("Decrypted: " + decrypted);

        System.out.println("\nSending message between droids:");
        Droid droid2 = new Droid();
        droid1.sendMessage("Secret Message", 5, droid2);
    }
}


