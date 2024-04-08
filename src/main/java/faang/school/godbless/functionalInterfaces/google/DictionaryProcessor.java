package faang.school.godbless.functionalInterfaces.google;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String, String> dictionaryProcessing) {
        dictionaryProcessing.accept(word, translate);
    }
}
