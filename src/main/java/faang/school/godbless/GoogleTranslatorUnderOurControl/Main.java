package faang.school.godbless.GoogleTranslatorUnderOurControl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    private static Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        String s1 = "Погода";
        String t1 = "Weather";
        String s2 = "Дождь";
        String t2 = "Rain";

        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        dictionaryProcessor.processWord(t1, s1, (s, t) -> dictionary.put(s, t));
        dictionaryProcessor.processWord(t2, s2, (s, t) -> dictionary.put(s, t));
        System.out.println(dictionary);
    }

}
