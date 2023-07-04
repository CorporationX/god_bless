import java.util.function.BiConsumer;

public class DictionaryProcessor {
    public void processWord(String word, String translate, BiConsumer<String, String> translateList){
        translateList.accept(word, translate);
    }
}
