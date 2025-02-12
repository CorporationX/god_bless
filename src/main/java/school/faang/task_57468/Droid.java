package school.faang.task_57468;

import lombok.Getter;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
public class Droid {
    private final String name;
    private List<Character> alphabet;

    public Droid(String name) {
        this.name = name;
        alphabet = new ArrayList<>();
        initializeAlphabet();
    }

    private void initializeAlphabet() {
        for (char c = 'A'; c <= 'Z'; c++) {
            alphabet.add(c);
        }

        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }
    }

    public String encryptMessage(String message, int key) {
        DroidMessageEncryptor encryptor = (decryptionMessage, decryptionKey) -> {
            StringBuilder builder = new StringBuilder();
            for (char c : decryptionMessage.toCharArray()) {
                int index = alphabet.indexOf(c);
                if (index == -1) {
                    builder.append(c);
                } else {
                    int newIndex = (index + decryptionKey) % alphabet.size();
                    char encryptedChar = alphabet.get(newIndex);
                    if (Character.isLowerCase(c)) {
                        builder.append(Character.toLowerCase(encryptedChar));
                    } else {
                        builder.append(alphabet.get(newIndex));
                    }
                }
            }
            return builder.toString();
        };
        return encryptor.encrypt(message, key);
    }
}
