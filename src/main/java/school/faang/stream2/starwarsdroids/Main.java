package school.faang.stream2.starwarsdroids;

public class Main {
    public static void main(String[] args) {
        DroidMessageEncryptor encryptorCaesar = ((message, key) -> {
            StringBuilder result = new StringBuilder();
            for (char c : message.toCharArray()) {
                c += key;
                result.append(c);
            }
            return result.toString();
        });

        Droid r2d2 = new Droid("R2D2");
        Droid c3po = new Droid("C3PO", encryptorCaesar);
        Droid bb8 = new Droid("BB-8");

        r2d2.setEncryptor(encryptorCaesar);
        bb8.setEncryptor(encryptorCaesar);

        String message1 = "Join the Rebellion!";
        String message2 = "The Death Star is operational!";
        int encryptionKey1 = 3;
        int encryptionKey2 = 7;

        r2d2.sendMessage(message1, encryptionKey1, c3po);
        c3po.sendMessage(message2, encryptionKey2, r2d2);
        bb8.sendMessage("The mission is complete.", encryptionKey1, c3po);
    }
}
