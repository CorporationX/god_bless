package school.faang.translator;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Main {
    public static Map<String, String> dictionary = new HashMap<>();

    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();
        // translation from English to French
        String sheet = "Sheet";
        String feuille = "Feuille";
        String remote = "Remote";
        String telecommande= "Telecommande";
        String spoken = "Spoken";
        String parle = "Parle";

        BiConsumer<String, String> addWordToDictionary = (word, tranlated) -> dictionary.put(word, tranlated);

        addWordToDictionary.accept(sheet, feuille);
        addWordToDictionary.accept(remote, telecommande);
        addWordToDictionary.accept(spoken, parle);

        dictionary.forEach((key, value) -> System.out.println("Word: " + key + " | Translate: " + value));
    }
}
