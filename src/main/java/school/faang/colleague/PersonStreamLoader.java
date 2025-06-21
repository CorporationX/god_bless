package school.faang.colleague;

import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * @author Danil Pudovkin
 * @since 21.06.2025
 */
@Slf4j(topic = "PersonStreamLoader")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class PersonStreamLoader {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    public static Stream<Person> load(File file) throws IOException {
        var factory = MAPPER.getFactory();
        var parser = factory.createParser(file);

        if (parser.nextToken() != JsonToken.START_ARRAY) {
            throw new IllegalStateException("JSON должен начинаться с массива");
        }

        var iterator = new Iterator<Person>() {
            @Override
            public boolean hasNext() {
                try {
                    return parser.nextToken() == JsonToken.START_OBJECT;
                } catch (IOException e) {
                    throw new IllegalStateException("JSON reading error", e.getCause());
                }
            }

            @Override
            public Person next() {
                try {
                    return MAPPER.readValue(parser, Person.class);
                } catch (IOException e) {
                    throw new IllegalStateException("JSON reading error", e.getCause());
                }
            }
        };

        return StreamSupport.stream(
                Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED),
                false
        ).onClose(() -> {
            try {
                parser.close();
            } catch (IOException e) {
                log.error(e.getMessage());
            }
        });
    }
}
