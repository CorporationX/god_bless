package stream;

import java.util.List;


import static stream.ResultPrinter.printResultBiFunction;
import static stream.ResultPrinter.printResult;

public class Main {
    private static final String SUBSTRING = "K";
    private static final String LIST_CONDITION = "Mashina";
    private static final int LINE_LENGTH = 6;
    private static final int SMALLEST_ELEMENT = 5;
    private static List<Integer> saveTheNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static List<String> saveTheString = List.of("Kirill", "Mashina", "Takoi", "Krasivb1");

    public static void main(String[] args) {


        printResult(PracticeStream::sumEvenNumbers, saveTheNumbers);
        printResult(PracticeStream::maxNumbers, saveTheNumbers);
        printResult(PracticeStream::averageNumbers, saveTheNumbers);
        printResult(PracticeStream::sortStringsByLength, saveTheString);
        printResult(PracticeStream::conversionString, saveTheString);

        printResultBiFunction(PracticeStream::ountStringsWithStartingCharacter, saveTheString, SUBSTRING);
        printResultBiFunction(PracticeStream::filterStrings, saveTheString, LIST_CONDITION);
        printResultBiFunction(PracticeStream::findSmallestElementGreaterThan, saveTheNumbers, SMALLEST_ELEMENT);
        printResultBiFunction(PracticeStream::checkAllElements, saveTheString, element -> element.length() > LINE_LENGTH);
    }
}