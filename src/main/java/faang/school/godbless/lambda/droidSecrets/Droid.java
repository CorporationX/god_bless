package faang.school.godbless.lambda.droidSecrets;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Droid {
    private String name;

    public String sendEncryptedMessage(Droid droid, String message, int key) throws IllegalArgumentException{
        if (droid == null) {
            throw new IllegalArgumentException("Дроид-получатель равен null!");
        }
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Переданное сообщение пусто!");
        }

        DroidMessageEncryptor droidMessageEncryptor = (str, keyEncrypt) -> {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) + keyEncrypt > 'Z' && str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                    stringBuilder.append((char) ((str.charAt(i) + keyEncrypt - 'Z') % 26 + 'A' - 1));
                }
                else if (str.charAt(i) + keyEncrypt > 'z' && str.charAt(i) >= 'a' && str.charAt(i) <= 'z') {
                    stringBuilder.append((char) ((str.charAt(i) + keyEncrypt - 'z') % 26 + 'a' - 1));
                }
                else if ((str.charAt(i) < 'A' || str.charAt(i) > 'Z') && (str.charAt(i) < 'a' || str.charAt(i) > 'z')) {
                    stringBuilder.append(str.charAt(i));
                }
                else {
                    stringBuilder.append((char) (str.charAt(i) + keyEncrypt));
                }
            }
            return stringBuilder.toString();
        };

        String encryptedMessage = droidMessageEncryptor.encrypt(message, key);
        System.out.println("Сообщение передано дроиду: " + droid.getName() + ". Зашифрованное сообщение: " + encryptedMessage);
        return encryptedMessage;
    }
}
