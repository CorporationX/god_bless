package school.faang.translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String originalWord, String translatedWord, BiConsumer<String, String> receiver) {
        receiver.accept(originalWord, translatedWord);
    }
}
