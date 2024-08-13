package faang.school.godbless.translater;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String word = "lake";
        String translate = "ozero";

        Map<String, String> dictionary = new HashMap<>();

        DictionaryProcessor processor = new DictionaryProcessor();
        processor.processWord(word, translate, dictionary::put);
    }
}
