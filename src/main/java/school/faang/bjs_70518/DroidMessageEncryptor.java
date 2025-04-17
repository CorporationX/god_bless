package school.faang.bjs_70518;

@FunctionalInterface
interface DroidMessageEncryptor {
    public String encrypt(String message, int key);
}
