package faang.school.godbless.google;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {

        DictionaryProcessor processor = new DictionaryProcessor();
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> addWordsToDictionary = dictionary::put;
        processor.processWord("apple", "Apfel", addWordsToDictionary);
        processor.processWord("tree", "Baum", addWordsToDictionary);
        processor.processWord("hand", "Arm", addWordsToDictionary);
       dictionary.forEach((word, translation) -> System.out.println(word + " translation to german: " +translation ));
    }
}
