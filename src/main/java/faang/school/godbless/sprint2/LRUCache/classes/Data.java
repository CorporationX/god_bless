package faang.school.godbless.sprint2.LRUCache.classes;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@RequiredArgsConstructor
public class Data {
    @NonNull
    private int id;
    @NonNull
    private String value;
    private Date timestamp;
}
