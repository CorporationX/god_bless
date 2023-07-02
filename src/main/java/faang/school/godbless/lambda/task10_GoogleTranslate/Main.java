package faang.school.godbless.lambda.task10_GoogleTranslate;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> map = new HashMap<>();

        BiConsumer<String, String> biConsumer = (word, translate) -> map.put(word, translate);

        dictionaryProcessor.processWord("Яблоко", "Apple", biConsumer);
        dictionaryProcessor.processWord("Хлеб", "Bread", biConsumer);
        dictionaryProcessor.processWord("Книга", "Book", biConsumer);
        dictionaryProcessor.processWord("Собака", "Dog", biConsumer);

        System.out.println("Словарь: " + map);

    }
}
