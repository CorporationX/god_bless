package faang.school.godbless.task20706;


import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;


@Getter
public class DictionaryProcessor {
    private Map<String, String> dictionary;

    public DictionaryProcessor() {
        dictionary = new HashMap<>();
    }

    public Map<String, String> getDictionary(){
        return dictionary;
    }

    public void processWord(String word, String translate, BiConsumer<String, String> dictionary){
        dictionary.accept(word, translate);
    }
}
