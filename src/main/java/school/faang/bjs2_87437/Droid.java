package school.faang.bjs2_87437;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Droid {
    private final String name;

    public String encryptMessage(String message, int key) {
        DroidMessageEnigma encrypt = (text, k) -> {
            StringBuilder sb = new StringBuilder(text.length());
            k = k % 26;
            for (char ch : text.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    sb.append((char) ((ch - 'A' + k + 26) % 26 + 'A'));
                } else if (Character.isLowerCase(ch)) {
                    sb.append((char) ((ch - 'a' + k + 26) % 26 + 'a'));
                } else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        };
        return encrypt.encryptOrDecrypt(message, key);
    }

    public String decryptMessage(String message, int key) {
        DroidMessageEnigma decrypt = (text, k) -> {
            StringBuilder sb = new StringBuilder(text.length());
            k = k % 26;
            for (char ch : text.toCharArray()) {
                if (Character.isUpperCase(ch)) {
                    sb.append((char) ((ch - 'A' - k + 26) % 26 + 'A'));
                } else if (Character.isLowerCase(ch)) {
                    sb.append((char) ((ch - 'a' - k + 26) % 26 + 'a'));
                } else {
                    sb.append(ch);
                }
            }
            return sb.toString();
        };
        return decrypt.encryptOrDecrypt(message, key);
    }

    public void receiveMessage(String encryptedMessage, int key) {
        System.out.println(decryptMessage(encryptedMessage, key));
    }

    public void sendMessage(Droid droid, String message, int key) {
        droid.receiveMessage(encryptMessage(message, key), key);
    }
}
