package school.faang.bjs2_71523;

import lombok.extern.slf4j.Slf4j;

import java.util.function.BiConsumer;

@Slf4j
public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> biConsumer) {
        if (word == null || translation == null || biConsumer == null) {
            log.warn("Слово, перевод и обработчик не должны быть null");
            return;
        }

        biConsumer.accept(word, translation);
    }
}
