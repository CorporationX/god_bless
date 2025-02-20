package school.faang.BJS2_57126;

import lombok.NonNull;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(@NonNull String word,
                            @NonNull String translation,
                            @NonNull BiConsumer<String, String> addWordToDictionary) {
        if (word.isBlank() || translation.isBlank()) {
            System.err.print("Error: word or translation are empty\n");
            return;
        }
        addWordToDictionary.accept(word, translation);
    }
}
