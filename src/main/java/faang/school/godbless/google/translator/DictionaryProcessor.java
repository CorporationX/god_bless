package faang.school.godbless.google.translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translate, BiConsumer<String, String> processing) {
        processing.accept(word, translate);
    }
}
