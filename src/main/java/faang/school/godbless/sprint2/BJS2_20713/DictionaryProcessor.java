package faang.school.godbless.sprint2.BJS2_20713;

import java.util.Objects;
import java.util.function.BiConsumer;

public class DictionaryProcessor {

    protected void processWord(String word, String translatedWord, BiConsumer<String, String> consumer) {
        Objects.requireNonNull(word);
        Objects.requireNonNull(translatedWord);
        Objects.requireNonNull(consumer);

        consumer.accept(word, translatedWord);
    }
}
