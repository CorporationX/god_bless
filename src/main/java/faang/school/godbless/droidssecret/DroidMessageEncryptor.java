package faang.school.godbless.droidssecret;

@FunctionalInterface
interface DroidMessageEncryptor {
    String encrypt(String message, int key);
}
