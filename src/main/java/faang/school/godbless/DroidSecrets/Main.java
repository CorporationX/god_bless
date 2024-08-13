package faang.school.godbless.DroidSecrets;

public class Main {

    public static void main(String[] args) {

        DroidMessageEncryptor encryptor = ((message, encryptKey) -> {

            StringBuilder encryptedMessage = new StringBuilder();

            for (int i = 0; i < message.length(); i++) {  //97-122 a-z в ASCII

                boolean backToUpperCase = false;
                char currentChar = message.charAt(i);

                if (Character.toLowerCase(currentChar) < 97 || Character.toLowerCase(currentChar) > 122) {
                    encryptedMessage.append(currentChar);
                    continue;
                }

                if (currentChar == Character.toUpperCase(currentChar)) {
                    backToUpperCase = true;
                }

                currentChar = (char) (Character.toLowerCase(currentChar) + encryptKey);

                if (currentChar > 122) {
                    currentChar -= 26;
                }

                if (backToUpperCase) {
                    currentChar = Character.toUpperCase(currentChar);
                }

                encryptedMessage.append(currentChar);
            }

            return encryptedMessage.toString();

        });
        DroidMessageDecryptor decryptor = ((message, decryptKey) -> {

            StringBuilder decryptedMessage = new StringBuilder();

            for (int i = 0; i < message.length(); i++) {  //97-122 a-z в ASCII

                boolean backToUpperCase = false;
                char currentChar = message.charAt(i);

                if (Character.toLowerCase(currentChar) < 97 || Character.toLowerCase(currentChar) > 122) {
                    decryptedMessage.append(currentChar);
                    continue;
                }

                if (currentChar == Character.toUpperCase(currentChar)) {
                    backToUpperCase = true;
                }

                currentChar = (char) (Character.toLowerCase(currentChar) - decryptKey);

                if (currentChar < 97) {
                    currentChar += 26;
                }

                if (backToUpperCase) {
                    currentChar = Character.toUpperCase(currentChar);
                }

                decryptedMessage.append(currentChar);
            }

            return decryptedMessage.toString();
        });

        Droid valera = new Droid("Валера", encryptor, new DroidMessageReceiver(decryptor));
        Droid pifagor = new Droid("C^2 = B^2 + A^2", encryptor, new DroidMessageReceiver(decryptor));

        pifagor.sendEncryptedMessage(valera, "aza", 1);

    }
}
