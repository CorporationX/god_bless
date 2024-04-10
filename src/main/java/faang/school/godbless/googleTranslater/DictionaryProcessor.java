package faang.school.godbless.googleTranslater;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String wordTranslation, BiConsumer<String, String> addToDictionary) {
        if (isValidWord(word) && isValidTranslation(wordTranslation)) {
            addToDictionary.accept(word, wordTranslation);
        } else {
            System.out.println("Error: enter word or text");
        }
    }

    private boolean isValidWord(String word) {
        return word != null && !word.isEmpty() && word.matches("[а-яА-Я]+");
    }

    private boolean isValidTranslation(String translation) {
        return translation != null && !translation.isEmpty() && translation.matches("[a-zA-Z]+");
    }
}
