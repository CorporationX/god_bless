package com.functional.google;

import lombok.NonNull;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> consumer) {
        if (word.isEmpty() && translation.isEmpty()) {
            return;
        }
        if (word.isBlank() && translation.isBlank()) {
            return;
        }
        if(word == null&& translation==null){
            return;
        }
        consumer.accept(word, translation);
    }
}
