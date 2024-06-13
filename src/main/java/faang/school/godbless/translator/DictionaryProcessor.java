package faang.school.godbless.translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation,
                            BiConsumer<String, String> putIntoDictionary) {
        putIntoDictionary.accept(word, translation);
    }
}
