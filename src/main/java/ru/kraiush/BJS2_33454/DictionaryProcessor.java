package ru.kraiush.BJS2_33454;

import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public void processWord(String word, String translation, BiConsumer<String, String> saver) {
        saver.accept(word, translation);
    }
}
