package faang.school.godbless.googleTranslator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> biConsumer) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Слово для перевода пустое!");
        }
        if (translation == null || translation.isEmpty()) {
            throw new IllegalArgumentException("Перевод слова пустой!");
        }
        if (biConsumer == null) {
            throw new IllegalArgumentException("Невозможно сохранить слово с переводом, метод null!");
        }
        biConsumer.accept(word, translation);
    }
}
