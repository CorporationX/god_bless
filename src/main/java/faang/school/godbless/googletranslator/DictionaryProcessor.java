package faang.school.godbless.googletranslator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> translator) {
        translator.accept(word, translation);
    }
}
