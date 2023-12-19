package faang.school.godbless.alexbulgakoff.functionalinterfaceslambdas.googletranslate;

import java.util.function.BiConsumer;

/**
 * @author Alexander Bulgakov
 */

public class DictionaryProcessor {

    public void processWord(String word, String translate,
                            BiConsumer<String, String> addWordToDictionary) {
        addWordToDictionary.accept(word, translate);
    }
}
