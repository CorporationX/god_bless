package faang.school.godbless;

import lombok.NonNull;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    @NonNull
    public void processWord(String word, String wordTranslation, BiConsumer biConsumer) {
        biConsumer.accept(word, wordTranslation);
    }
}
