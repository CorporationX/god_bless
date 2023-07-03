package faang.school.godbless.sprint3.lambda.task11;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translateWord, BiConsumer<String, String> biConsumer) {
        if (word.isBlank() || translateWord.isBlank()) {
            throw new IllegalArgumentException("Введены неправильные данные!");
        }
        if (biConsumer == null) {
            throw new NullPointerException("BiConsumer не может быть null");
        }
        biConsumer.accept(word, translateWord);
    }
}
