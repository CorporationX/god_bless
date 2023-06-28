package faang.school.godbless.sprint2.droidSecret;

public class Droid {
    public String sendEncryptedMessage(Droid droid, String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> {
            if(message == null || message.isEmpty()){
                throw new IllegalArgumentException("message is null");
            }

            int n = message.length();
            char[] result = new char[n];
            for (int i = 0; i < n; i++) {
                char c = message.charAt(i);
                if (Character.isLetter(c)) {
                    char base = Character.isUpperCase(c) ? 'A' : 'a';
                    int index = c - base;
                    int shiftedIndex = (index + key) % 26;
                    char shiftedChar = (char) (base + shiftedIndex);
                    result[i] = shiftedChar;
                } else {
                    result[i] = c;
                }
            }
            return new String(result);

        };
        return droidMessageEncryptor.encryptor(message, key);
    }

}

