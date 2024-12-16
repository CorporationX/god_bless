package school.faang.task_45434;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> addANewWord) {
        addANewWord.accept(word, translation);
        System.out.println("Слово " + word + " успешно добавлено в ваш словарь");
    }
}
