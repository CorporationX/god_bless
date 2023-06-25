package faang.school.godbless.lambda.google;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String originalWord, String translate, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(originalWord, translate);
    }
}
