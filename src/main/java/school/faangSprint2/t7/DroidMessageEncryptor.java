package school.faangSprint2.t7;

@FunctionalInterface
interface DroidMessageEncryptor {
    String process(String message, int key);
}