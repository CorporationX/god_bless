package faang.school.godbless.FilterSpam;

import java.util.List;

@FunctionalInterface
interface MessageFilter {
    boolean filter (String message);
}
