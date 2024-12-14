package faang.school.godbless.GoogleTranslator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> handler){
        handler.accept(word, translation);
    }
}
