package faang.school.godbless.GoogleTranslator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translatedWord, BiConsumer<String, String> biConsumer) {
        try {
            if (biConsumer != null) {
                biConsumer.accept(word, translatedWord);
            } else {
                throw new NullPointerException("Word handler argument is null");
            }
        } catch (NullPointerException e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
