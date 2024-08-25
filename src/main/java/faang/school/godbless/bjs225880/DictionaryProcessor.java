package faang.school.godbless.bjs225880;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> wordProcessor) {
        wordProcessor.accept(word, translation);
    }
}