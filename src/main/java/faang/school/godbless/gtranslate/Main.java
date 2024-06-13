package faang.school.godbless.gtranslate;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        Map<String,String> dict = new HashMap<>();
        dictionaryProcessor.processWord("Привет","Hello", dict::put);
        dictionaryProcessor.processWord("Самолёт","Airplane", dict::put);
        dictionaryProcessor.processWord("Машина","Car", dict::put);
        System.out.println("dict"+dict);
    }
}
