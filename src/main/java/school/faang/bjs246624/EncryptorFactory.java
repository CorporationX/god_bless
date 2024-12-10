package school.faang.bjs246624;

public class EncryptorFactory {

    public static DroidMessageEncryptor getEncryptor(String type) {
        if ("ENCRYPTOR".equals(type)) {
            return new DroidMessageEncryptorEncrypt();
        } else if ("DECRYPTOR".equals(type)) {
            return new DroidMessageEncryptorDecrypt();
        }
        throw new IllegalArgumentException("Unknown encryptor type: " + type);
    }

}
