package school.faang.droidsecret.maincode;

@FunctionalInterface
public interface DroidMessageEnctyptor {
    void messageEncrypt(String line, int encryptionKey);
}
