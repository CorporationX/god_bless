package school.faang.task45417;

import lombok.Getter;

import java.util.function.BiConsumer;

@Getter
public class DictionaryProcessor {

    public void processWord(String word, String translate, BiConsumer<String, String> consumer) {
        if (word == null || word.isBlank()) {
            throw new IllegalArgumentException("word is null");
        }
        if (translate == null || translate.isBlank()) {
            throw new IllegalArgumentException("translate is null");
        }
        if (consumer == null) {
            throw new IllegalArgumentException("consumer is null");
        }

        consumer.accept(word, translate);
    }
}
