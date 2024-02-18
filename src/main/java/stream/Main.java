package stream;

import java.util.List;

public class Main {
    private static List<Integer> saveTheNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static List<String> saveTheString = List.of("Kirill", "Mashina", "Takoi", "Krasivb1");

    public static void main(String[] args) {


        System.out.println(practiceStream.sumNumbers(saveTheNumbers));
        System.out.println(practiceStream.maxNumbers(saveTheNumbers));
        System.out.println(practiceStream.averageNumbers(saveTheNumbers));
        System.out.println(practiceStream.searchForSymbol(saveTheString, "K"));
        System.out.println(practiceStream.filterStrings(saveTheString, "Mashina"));
        System.out.println(practiceStream.sortedLongStrings(saveTheString));
        System.out.println(practiceStream.processingByParameter(saveTheString, element -> element.length() > 6));
        System.out.println(practiceStream.searchingForMore(saveTheNumbers, 5));
        System.out.println(practiceStream.conversionString(saveTheString));
    }
}
