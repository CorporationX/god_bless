package faang.school.godbless.lambda_stream.droid_secrets;

public class Droid {
    //  У меня здесь шифр Цезаря, алгоритм шифрования и дешифрования очень похож, отличается только +key или -key,
//  но как я понял задание, здесь лямбды для удобного изменения логики шифрования и дешифр, верно понимаю ?.
    public String sendEncryptedMessage(Droid toDroid, String message, int key) {
        DroidMessageEncryptor droidMessageEncryptor = (m, k) -> {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < m.length(); i++) {
                int originalPosition = m.charAt(i);
                char newCh = (char) (originalPosition + k);
                result.append(newCh);
            }
            return result.toString();
        };
        return droidMessageEncryptor.encrypt(message, key);
    }
}

