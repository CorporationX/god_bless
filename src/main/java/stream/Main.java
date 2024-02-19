package stream;

import java.util.List;


import static stream.printResult.printResultBiFunctionPredicate;
import static stream.printResult.printResultBiFunction;
import static stream.printResult.printResult;

public class Main {
    private static List<Integer> saveTheNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static List<String> saveTheString = List.of("Kirill", "Mashina", "Takoi", "Krasivb1");

    public static void main(String[] args) {


        printResult(PracticeStream::sumEvenNumbers, saveTheNumbers);
        printResult(PracticeStream::maxNumbers, saveTheNumbers);
        printResult(PracticeStream::averageNumbers, saveTheNumbers);
        printResult(PracticeStream::sortStringsByLength, saveTheString);
        printResult(PracticeStream::conversionString, saveTheString);

        printResultBiFunction(PracticeStream::ountStringsWithStartingCharacter, saveTheString, "K");
        printResultBiFunction(PracticeStream::filterStrings, saveTheString, "Mashina");
        printResultBiFunction(PracticeStream::findSmallestElementGreaterThan, saveTheNumbers, 5);

        printResultBiFunctionPredicate(PracticeStream::checkAllElements, saveTheString, element -> element.length() > 6);
    }
}
