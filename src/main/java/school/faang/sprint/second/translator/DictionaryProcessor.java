package school.faang.sprint.second.translator;

import lombok.NonNull;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(@NonNull String word,
                            @NonNull String translation,
                            @NonNull BiConsumer<String, String> biConsumer) {
        validateInputData(word, translation);
        biConsumer.accept(word, translation);
    }

    private void validateInputData(@NonNull String word, @NonNull String translation) {
        if (word.isBlank() || translation.isBlank()) {
            throw new WordBlankException();
        }
    }
}
