package faang.school.godbless.lambdas.googletrans;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String originalWord, String translatedWord,
                            BiConsumer<String, String> biConsumer) {
        biConsumer.accept(originalWord, translatedWord);
    }
}
