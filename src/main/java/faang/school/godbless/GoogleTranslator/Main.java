package faang.school.godbless.GoogleTranslator;

import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final Map<String, String> TRANSLATIONS = new HashMap<String, String>();

    public static void main(String[] args) {
        String origin = "Cheese";
        String translated = "Сыр";

        DictionaryProcessor.processWord(origin, translated, (originTemp, translatedTemp) -> {
            TRANSLATIONS.put(originTemp, translatedTemp);
        });

        origin = "Toilet";
        translated = "Туалет";

        DictionaryProcessor.processWord(origin, translated, (originTemp, translatedTemp) -> {
            TRANSLATIONS.put(originTemp, translatedTemp);
        });

        TRANSLATIONS.forEach( (originTemp, translatedTemp) -> {
            System.out.println(originTemp + " : " + translatedTemp);
        });
    }
}
