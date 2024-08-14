package index;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

@Getter
@ToString
@AllArgsConstructor

public class Query{
    private int id;
    private String content;
    private int timestamp;

}

