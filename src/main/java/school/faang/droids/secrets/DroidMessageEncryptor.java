package school.faang.droids.secrets;

@FunctionalInterface
interface DroidMessageEncryptor {
    String perform(String input, int key);
}
