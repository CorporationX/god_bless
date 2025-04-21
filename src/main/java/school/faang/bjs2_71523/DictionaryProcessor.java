package school.faang.bjs2_71523;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;

@Slf4j
public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> dictionaryConsumer) {
        if (word == null || translation == null || dictionaryConsumer == null) {
            log.warn("Слово, перевод и обработчик не должны быть null");
            return;
        }

        dictionaryConsumer.accept(word, translation);
    }
}
