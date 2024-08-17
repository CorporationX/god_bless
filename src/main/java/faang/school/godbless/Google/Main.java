package faang.school.godbless.Google;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        Map<String, String> dictionary = new HashMap<>();

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        BiConsumer biConsumer = ((first, second) -> dictionary.put(first, second));

        dictionaryProcessor.processWord("One", "Один", biConsumer);
        dictionaryProcessor.processWord("Two", "Два", biConsumer);
        dictionaryProcessor.processWord("Three", "Три", biConsumer);

        dictionary.entrySet().stream().forEach(word -> System.out.println(word.getKey() + " - " + word.getValue()));
    }
}
