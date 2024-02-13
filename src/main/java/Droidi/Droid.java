package Droidi;

public class Droid {
    public static void sendMessageEncryptor(String msg, int cypher){
        DroidMessageEncryptor droidMessageEncryptor = (message, cypher2) -> {
            StringBuilder encryptedMessage = new StringBuilder();

            for (char ch : message.toCharArray()) {
                if (Character.isLetter(ch)) {
                    char base;
                    if (Character.isLowerCase(ch)) {
                        base = 'a';
                    } else {
                        base = 'A';
                    }
                    char shifted = (char) ((ch + cypher2 - base + 26) % 26 + base);
                    encryptedMessage.append(shifted);
                } else {
                    encryptedMessage.append(ch);
                }
            }

            System.out.println(encryptedMessage);
            return encryptedMessage.toString();
        };

        receiveMessageEncryptor(droidMessageEncryptor, msg, cypher);
    }


    public static void receiveMessageEncryptor(DroidMessageEncryptor droidMessageEncryptor, String msg, int cypher) {
        droidMessageEncryptor.cypherMsg(msg, cypher);
    }
}


