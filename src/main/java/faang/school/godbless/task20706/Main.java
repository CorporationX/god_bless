package faang.school.godbless.task20706;

import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        BiConsumer<String, String> dictionary = (word, translate) -> {
             dictionaryProcessor.getDictionary().put(word, translate);
        };

        dictionaryProcessor.processWord("сat","кот", dictionary);
        dictionaryProcessor.processWord("environment","окружение", dictionary);
        dictionaryProcessor.processWord("cake","торт", dictionary);
        System.out.println(dictionaryProcessor.getDictionary());
    }
}
