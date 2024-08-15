package faang.school.godbless.GoogleTranslate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer biConsumer) {
        biConsumer.accept(word, translate);
    }
}
