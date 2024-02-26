package faang.school.godbless.BJS2_2986;

public class Droid {
    public String sendEncryptedMessage(String message, Integer encryptionKey) {
        DroidMessageEncryptor encryptor = () -> {
        };
        // Я не понял как оставить использование лямбд и вызвать дефолтный метод
        // поэтому получилось как-то нелогично, но работает и нет дублирования кода
        return encryptor.encryptionHelper(message, encryptionKey);
    }

    public String receiveEncryptedMessage(String message, Integer encryptionKey) {
        DroidMessageEncryptor encryptor = () -> {
        };
        return encryptor.encryptionHelper(message, -encryptionKey);
    }

}
