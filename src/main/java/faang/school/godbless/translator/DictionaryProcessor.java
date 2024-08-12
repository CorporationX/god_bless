package faang.school.godbless.translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String initialWord, String translation, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(initialWord, translation);
    }
}
