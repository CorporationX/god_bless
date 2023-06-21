package faang.school.godbless.google_translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String string, String translation, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(string, translation);
    }
}
