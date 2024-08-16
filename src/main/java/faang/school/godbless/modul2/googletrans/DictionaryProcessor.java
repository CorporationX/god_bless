package faang.school.godbless.modul2.googletrans;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String, String> consumer) {
        if (word == null || translate == null) {
            throw new NullPointerException("Word or translate can't be null");
        }
        consumer.accept(word, translate);
    }
}
