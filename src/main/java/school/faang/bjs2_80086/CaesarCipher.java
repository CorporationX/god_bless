package school.faang.bjs2_80086;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CaesarCipher {
    public DroidMessageEncryptor encryptCaesar() {
        return (message, key) -> {
            char[] letters = message.toCharArray();
            int lettersLength = letters.length;

            for (int i = 0; i < lettersLength; i++) {
                char letter = letters[i];
                if (Character.isLetter(letter)) {
                    char base = Character.isLowerCase(letter) ? 'a' : 'A';
                    letters[i] = shift(base, letters[i], normalizeKey(key));
                }
            }
            return new String(letters);
        };
    }

    private char shift(char base, char letter, int normalizeKey) {
        return (char) (base + (letter - base + normalizeKey) % 26);

    }

    private int normalizeKey(int key) {
        return (key % 26 + 26) % 26;
    }
}
