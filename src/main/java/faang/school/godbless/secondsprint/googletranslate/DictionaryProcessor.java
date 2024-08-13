package faang.school.godbless.secondsprint.googletranslate;

import lombok.NonNull;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(@NonNull String word,
                            @NonNull String translation,
                            @NonNull BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translation);
    }
}
