package faang.school.godbless.sprint2.BJS2_5389;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translatedWord, BiConsumer<String, String> biConsumer) {
        biConsumer.accept(word, translatedWord);
    }
}
