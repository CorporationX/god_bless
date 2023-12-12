package faang.school.godbless.googleTranslator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    void processWord(String word, String translate, BiConsumer<String, String> handlerDictionary){
        handlerDictionary.accept(word,translate);
    }
}
