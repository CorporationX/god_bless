package BJS2_5181;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translationWord, BiConsumer consumer) {
        if(word == null || translationWord == null) {
            throw new IllegalArgumentException();
        }
        consumer.accept(word, translationWord);
    }
}
