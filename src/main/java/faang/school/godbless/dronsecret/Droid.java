package faang.school.godbless.dronsecret;

public class Droid {

    DroidMessageEncryptor droidMessageEncryptor;

    public Droid() {
        this.droidMessageEncryptor = encryptorInitializer();
    }

    public String sendEncryptedMessage(String messageToEncrypt, int cryptCode) {
        return droidMessageEncryptor.encryptMessage(messageToEncrypt, cryptCode);
    }

    public String receiveEncryptedMessage(String messageToDecrypt, int cryptCode) {
        return droidMessageEncryptor.encryptMessage(messageToDecrypt, 26 - cryptCode);
    }

    public DroidMessageEncryptor encryptorInitializer() {
        droidMessageEncryptor = (message, cryptCode) -> {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < message.length(); i++) {
                if (Character.isLetter(message.charAt(i))) {
                    if (Character.isUpperCase(message.charAt(i))) {
                        char ch = (char) (((int) message.charAt(i) + cryptCode - 65) % 26 + 65);
                        sb.append(ch);
                    } else {
                        char ch = (char) (((int) message.charAt(i) + cryptCode - 97) % 26 + 97);
                        sb.append(ch);
                    }
                } else {
                    sb.append(message.charAt(i));
                }
            }
            return sb.toString();
        };
        return droidMessageEncryptor;
    }
}
