package school.faang.bjs2_87322;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String, String> mapWord = new HashMap<>();

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        BiConsumer<String, String> addBiConsumer = (rus, eng) -> mapWord.put(rus, eng);

        dictionaryProcessor.processWord("Привет", "Hello", addBiConsumer);
        dictionaryProcessor.processWord("Мир", "World", addBiConsumer);
        dictionaryProcessor.processWord("Кот", "Cat", addBiConsumer);

        System.out.println(mapWord);
    }
}
