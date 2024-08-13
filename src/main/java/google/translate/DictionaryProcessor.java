package google.translate;

import lombok.NonNull;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(@NonNull String word,
                            @NonNull String translatedWord,
                            @NonNull BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translatedWord);
    }
}
