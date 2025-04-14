package school.faang.star_wars;

@FunctionalInterface
interface DroidMessageEncryptor {
    String process(String message, int key);
}
