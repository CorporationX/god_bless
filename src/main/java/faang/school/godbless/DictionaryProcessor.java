package faang.school.godbless;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String, String> addTranslate) {
        addTranslate.accept(word, translate);
    }
}
