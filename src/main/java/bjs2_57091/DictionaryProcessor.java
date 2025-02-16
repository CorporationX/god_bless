package bjs2_57091;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translation, BiConsumer<String, String> translate) {
        throwIfNull(word, "word");
        throwIfNull(translation, "translation");
        throwIfNull(translate, "translate");

        translate.accept(word, translation);
    }

    private static <T> void throwIfNull(T argument, String argumentName) {
        if (argument == null) {
            throw new IllegalArgumentException(String.format("Аргумент '%s' не должен быть равен null", argumentName));
        }
    }
}
