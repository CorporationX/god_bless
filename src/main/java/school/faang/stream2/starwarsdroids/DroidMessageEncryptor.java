package school.faang.stream2.starwarsdroids;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String processMessage(String message, Integer key);
}
