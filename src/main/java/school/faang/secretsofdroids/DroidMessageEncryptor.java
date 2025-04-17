package school.faang.secretsofdroids;

import java.util.Arrays;
import java.util.stream.Collectors;

@FunctionalInterface
public interface DroidMessageEncryptor {
    String process(String message, int key);

    static DroidMessageEncryptor caesar() {
        return (m, k) ->
                Arrays.stream(m.split(" "))
                        .map(word -> word.chars()
                                .mapToObj(c -> {
                                    if (Character.isLetter(c)) {
                                        char base = Character.isUpperCase(c) ? 'A' : 'a';
                                        int offset = (c - base + k) % 26;
                                        if (offset < 0) {
                                            offset += 26;
                                        }
                                        return String.valueOf((char) (base + offset));
                                    } else {
                                        return String.valueOf((char) (c));
                                    }
                                })
                                .collect(Collectors.joining()))
                        .collect(Collectors.joining(" "));
    }
}
