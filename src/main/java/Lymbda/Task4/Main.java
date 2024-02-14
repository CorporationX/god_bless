package Lymbda.Task4;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        Map<String,String> dictionary = new HashMap<>();
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        dictionaryProcessor.processWord("яблоко","apple",(inRussian,inEnglish) -> dictionary.put(inRussian,inEnglish));
        dictionaryProcessor.processWord("банан","banana",(inRussian,inEnglish) -> dictionary.put(inRussian,inEnglish));
        dictionaryProcessor.processWord("телефон","phone",(inRussian,inEnglish) -> dictionary.put(inRussian,inEnglish));
        System.out.println("Словарь "+dictionary);
    }
}
