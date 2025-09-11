package school.faang.bjs2_87296;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    protected void processWord(String word, String translateWord, BiConsumer<String, String> translator) {
        translator.accept(word, translateWord);
    }
}
