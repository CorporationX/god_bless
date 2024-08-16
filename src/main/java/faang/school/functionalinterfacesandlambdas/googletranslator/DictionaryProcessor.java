package faang.school.functionalinterfacesandlambdas.googletranslator;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> biConsumer) {
        if (!validationProcessWord(word, translation, biConsumer)) {
            System.out.println(validationProcessWord(word, translation, biConsumer));
            biConsumer.accept(word, translation);
        }
    }

    private boolean validationProcessWord(String word, String translation, BiConsumer<String, String> biConsumer) {
        return word == null
                || word.isBlank()
                || translation == null
                || translation.isBlank()
                || biConsumer == null;
    }
}
