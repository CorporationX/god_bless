package faang.school.godbless.googlTranslatorUnderOurControl;

import java.util.function.BiConsumer;

public class DictionaryProcessor {
    void processWord(String name, String translate, BiConsumer<String, String> addWordToDictionary) {
        addWordToDictionary.accept(name, translate);
    }
}