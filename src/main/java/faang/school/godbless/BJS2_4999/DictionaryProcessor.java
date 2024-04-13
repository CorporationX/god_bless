package faang.school.godbless.BJS2_4999;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String, String> savingWord) {
        savingWord.accept(word, translate);
    }
}
