package faang.school.godbless.GoogleTranslatorUnderOurControl;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    void processWord(String word, String translate, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translate);
    }
}
