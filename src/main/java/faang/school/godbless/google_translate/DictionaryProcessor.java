package faang.school.godbless.google_translate;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translateWord, BiConsumer<String, String> function) {
        if (word == null || translateWord == null || function == null) {
            throw new NullPointerException("Some fields are null");
        }

        function.accept(word, translateWord);
    }
}