package school.faang.bjs246624;

public class EncryptorFactory {

    public static DroidMessageMutator getEncryptor(String type) {
        if ("ENCRYPTOR".equals(type)) {
            return new DroidMessageMutatorEncrypt();
        } else if ("DECRYPTOR".equals(type)) {
            return new DroidMessageMutatorDecrypt();
        }
        throw new IllegalArgumentException("Unknown encryptor type: " + type);
    }

}
