package faang.school.godbless.BJS2_22724;

import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        String inputString1 = "\"{\\n    " +
                "\\\"position\\\": \\\"programmer\\\",\\n  " +
                "  \\\"salary\\\": \\\"100000\\\",\\n   " +
                " \\\"location\\\": \\\"Kazan\\\",\\n  " +
                "  \\\"date\\\": \\\"2024-08-17 11-02-25\\\",\\n  " +
                "  \\\"requirements\\\": [\\n  " +
                    "    \\\"sociable\\\",\\n  " +
                    "    \\\"responsible\\\",\\n   " +
                    "   \\\"learnable\\\",\\n    " +
                    "  \\\"java core\\\",\\n    " +
                    "  \\\"spring\\\"\\n " +
                "   ]\\n}\"";
        String inputString2 = "\"{\\n    " +
                "\\\"position\\\": \\\"driver\\\",\\n  " +
                "  \\\"salary\\\": \\\"50000\\\",\\n   " +
                " \\\"location\\\": \\\"Moscow\\\",\\n  " +
                "  \\\"date\\\": \\\"2024-05-17 17-02-25\\\",\\n  " +
                "  \\\"requirements\\\": [\\n  " +
                "    \\\"sociable\\\",\\n  " +
                "    \\\"responsible\\\",\\n   " +
                "   ]\\n}\"";
        String inputString3 = "\"{\\n    " +
                "\\\"position\\\": \\\"programmer\\\",\\n  " +
                "  \\\"salary\\\": \\\"25000\\\",\\n   " +
                " \\\"location\\\": \\\"Samara\\\",\\n  " +
                "  \\\"date\\\": \\\"2024-08-01 17-02-25\\\",\\n  " +
                "  \\\"requirements\\\": [\\n  " +
                "    \\\"sociable\\\",\\n  " +
                "    \\\"responsible\\\",\\n   " +
                "   \\\"learnable\\\",\\n    " +
                "  \\\"java core\\\",\\n    " +
                "   ]\\n}\"";
        String inputString4 = "\"{\\n    " +
                "\\\"position\\\": \\\"manager\\\",\\n  " +
                "  \\\"salary\\\": \\\"900000\\\",\\n   " +
                " \\\"location\\\": \\\"Moscow\\\",\\n  " +
                "  \\\"date\\\": \\\"2024-08-14 17-02-25\\\",\\n  " +
                "  \\\"requirements\\\": [\\n  " +
                "    \\\"sociable\\\",\\n  " +
                "    \\\"responsible\\\",\\n   " +
                "   \\\"learnable\\\",\\n    " +
                "  \\\"communicative\\\",\\n    " +
                "   ]\\n}\"";
        String inputString5 = "\"{\\n    " +
                "\\\"position\\\": \\\"programmer\\\",\\n  " +
                "  \\\"salary\\\": \\\"300000\\\",\\n   " +
                " \\\"location\\\": \\\"Moscow\\\",\\n  " +
                "  \\\"date\\\": \\\"2023-08-17 17-02-25\\\",\\n  " +
                "  \\\"requirements\\\": [\\n  " +
                "    \\\"sociable\\\",\\n  " +
                "    \\\"responsible\\\",\\n   " +
                "   \\\"learnable\\\",\\n    " +
                "  \\\"java core\\\",\\n    " +
                "  \\\"spring\\\"\\n " +
                "   ]\\n}\"";
        String inputString6 = "\"{\\n    " +
                "\\\"position\\\": \\\"manager\\\",\\n  " +
                "  \\\"salary\\\": \\\"110000\\\",\\n   " +
                " \\\"location\\\": \\\"Kazan\\\",\\n  " +
                "  \\\"date\\\": \\\"2024-07-17 17-02-25\\\",\\n  " +
                "  \\\"requirements\\\": [\\n  " +
                "    \\\"sociable\\\",\\n  " +
                "    \\\"responsible\\\",\\n   " +
                "   \\\"learnable\\\",\\n    " +
                "  \\\"communicative\\\"\\n " +
                "   ]\\n}\"";

        Stream<String>streamOfString = Stream.of(inputString1,inputString2,inputString3,inputString4,inputString5,inputString6);
        JobStreamProcessor jobStreamProcessor = new JobStreamProcessor();
        List<Job> allJobs = jobStreamProcessor.process(streamOfString);
        allJobs.forEach(System.out::println);
        DataAnalyzer analyzer = new DataAnalyzer();
        analyzer.mostPopularSkills(allJobs);
    }
}
