package faang.school.godbless.google;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translateWord, BiConsumer<String, String> managerDictionary) {
        if(word == null) {
            throw new IllegalArgumentException("word not be null");
        }
        if(translateWord == null) {
            throw new IllegalArgumentException("translate word not be null");
        }
        managerDictionary.accept(word, translateWord);
    }
}
