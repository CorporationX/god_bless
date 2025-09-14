package school.faang.lambda.bjs2_87304;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translatedWord, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translatedWord);
    }
}