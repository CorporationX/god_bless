package faang.school.godbless.BJS2_4999;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String, String> map = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = (word, translation) -> map.put(word, translation);
        dictionaryProcessor.processWord("Katarina", "Катарина", addWordToDictionary);
        dictionaryProcessor.processWord("League of legends", "Лига легенд", addWordToDictionary);
        dictionaryProcessor.processWord("Akali", "Акали", addWordToDictionary);

        System.out.println("Словарь: " + map);
    }
}
