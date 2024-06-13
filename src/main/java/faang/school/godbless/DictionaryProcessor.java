package faang.school.godbless;

import lombok.NonNull;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    @NonNull
    public void processWord(String word, String wordTranslation,
                            BiConsumer puttingIntoTheDictionary) {
        puttingIntoTheDictionary.accept(word, wordTranslation);
    }
}
