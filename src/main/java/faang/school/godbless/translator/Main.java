package faang.school.godbless.translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static void main(String[] args) {
        DictionaryProcesssor dictionaryProcesssor = new DictionaryProcesssor();

        Map<String, String> dictionaryRuEn = new HashMap<>();
        Map<String, String> dictionaryEnJa = new HashMap<>();

        BiConsumer<String, String> addWordToRussianEnglishDictionary = (word, translation) -> dictionaryRuEn.put(word.toLowerCase(), translation.toLowerCase());
        BiConsumer<String, String> addWordToEnglishJapaneseDictionary = (word, translation) -> dictionaryEnJa.put(word.toLowerCase(), translation.toLowerCase());

        dictionaryProcesssor.processWord("привет", "hello", addWordToRussianEnglishDictionary);
        dictionaryProcesssor.processWord("Мир", "world", addWordToRussianEnglishDictionary);
        dictionaryProcesssor.processWord("программирование", "programming", addWordToRussianEnglishDictionary);

        dictionaryProcesssor.processWord("Welcome", "ようこそ", addWordToEnglishJapaneseDictionary);
        dictionaryProcesssor.processWord("Bye", "さよなら", addWordToEnglishJapaneseDictionary);
        dictionaryProcesssor.processWord("Yes", "はい", addWordToEnglishJapaneseDictionary);

        System.out.println("Russian - English dictionary: " + dictionaryRuEn);
        System.out.println("English - Japanese dictionary: " + dictionaryEnJa);
    }
}
