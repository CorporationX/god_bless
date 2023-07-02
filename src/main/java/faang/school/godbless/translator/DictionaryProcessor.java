package faang.school.godbless.translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translateWord, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translateWord);
    }
}
