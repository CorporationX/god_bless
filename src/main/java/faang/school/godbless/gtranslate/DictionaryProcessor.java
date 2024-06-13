package faang.school.godbless.gtranslate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translator, BiConsumer<String,String> action) {
        action.accept(word,translator);
    }
}
