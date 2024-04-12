package faang.school.godbless.BJS2_5280;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translatedWord, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translatedWord);
    }
}
