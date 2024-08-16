package BJS2_20736_GoogleTranslator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, List<String>> helloDictionary = new HashMap<>();
        List<String> hiOnDifferentLanguages = List.of("Hi", "Salut", "Hallo", "Ciao", "Selam", "Hej");

        BiConsumer<String, List<String>> addToDictionary = helloDictionary::put;

        DictionaryProcessor.processWord("Привет", hiOnDifferentLanguages, addToDictionary);

        System.out.println("Dictionary: " + helloDictionary);
    }
}
