package com.functional.google;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> consumer) {
        if (!word.isEmpty() && !translation.isEmpty()) {
            consumer.accept(word, translation);
        }
    }
}
