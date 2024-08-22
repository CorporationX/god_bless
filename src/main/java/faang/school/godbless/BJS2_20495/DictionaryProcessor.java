package faang.school.godbless.BJS2_20495;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translate, BiConsumer<String, String> dictionary) {
        dictionary.accept(word, translate);
    }
}
