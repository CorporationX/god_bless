package faang.school.godbless.BJS2_923;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public static void main(String[] args) {
        Map<String, String> dictionary = new HashMap<>();
        BiConsumer<String, String> biConsumer = (word, translation) -> dictionary.put(word, translation);
        processWord("apple", "яблоко", biConsumer);
        processWord("patience", "терпение", biConsumer);
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry);
        }
    }

    public static void processWord(String word, String translatedWord, BiConsumer<String, String> biConsumer){
        biConsumer.accept(word, translatedWord);
    }
}
