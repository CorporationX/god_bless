package faang.school.godbless.google_translator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> consumer) {
        if (isValidData(word, translation)) {
            consumer.accept(word, translation);
        } else {
            System.out.println("Данные не могут быть пустыми!");
        }
    }

    private boolean isValidData(String word, String translation) {
        return word != null && !word.isBlank() && translation != null && !translation.isBlank();
    }
}
