import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class Application {
    public static void main(String[] args) {
        DictionaryProcessor dictionaryProcessor = new DictionaryProcessor();

        Map<String, String> dictionary = new HashMap<>();

        BiConsumer<String, String> addWordToDictionary = (word, wordTranslate) -> dictionary.put(word, wordTranslate);

        dictionaryProcessor.processWord("стол", "table", addWordToDictionary);
        dictionaryProcessor.processWord("стул", "chair", addWordToDictionary);
        dictionaryProcessor.processWord("книга", "book", addWordToDictionary);

        System.out.println("Словарь" + dictionary);
    }
}
