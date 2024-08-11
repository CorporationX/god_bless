package faang.school.godbless.BJS2_20427;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {

    public static void processWord(String word, String translation, BiConsumer<String, String> addToDictionary){
        if (word.isBlank())
            throw new IllegalArgumentException("Word must be filled");
        if (translation.isBlank())
            throw new IllegalArgumentException("Translation must be filled");

        addToDictionary.accept(word, translation);
    }

    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addToDictionary = dictionary::put;

        processWord("Czeszć", "Hello", addToDictionary);
        processWord("Do widzenia", "Goodbye", addToDictionary);

        dictionary.forEach((word, translation) -> System.out.println("Original word is: " + word + ", translation is: " + translation));
    }
}
