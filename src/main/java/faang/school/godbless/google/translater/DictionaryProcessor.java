package faang.school.godbless.google.translater;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String originWord, String translatedWord, BiConsumer<String, String> wordsAdder) {
        wordsAdder.accept(originWord, translatedWord);
    }
}
