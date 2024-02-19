package stream;

import java.util.List;

public class Main {
    private static List<Integer> saveTheNumbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
    private static List<String> saveTheString = List.of("Kirill", "Mashina", "Takoi", "Krasivb1");

    public static void main(String[] args) {


        System.out.println(PracticeStream.sumEvenNumbers(saveTheNumbers));
        System.out.println(PracticeStream.maxNumbers(saveTheNumbers));
        System.out.println(PracticeStream.averageNumbers(saveTheNumbers));
        System.out.println(PracticeStream.ountStringsWithStartingCharacter(saveTheString, "K"));
        System.out.println(PracticeStream.filterStrings(saveTheString, "Mashina"));
        System.out.println(PracticeStream.sortStringsByLength(saveTheString));
        System.out.println(PracticeStream.checkAllElements(saveTheString, element -> element.length() > 6));
        System.out.println(PracticeStream.findSmallestElementGreaterThan(saveTheNumbers, 5));
        System.out.println(PracticeStream.conversionString(saveTheString));
    }
}
