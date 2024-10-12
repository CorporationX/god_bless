package school.faang.tanslator_under_control_BJS2_33480;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translatedWord, BiConsumer<String, String> consumer) {
        consumer.accept(word, translatedWord);
    }
}
