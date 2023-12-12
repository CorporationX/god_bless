package faang.school.godbless.google_translate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String original, String translate, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(original, translate);
    }
}
