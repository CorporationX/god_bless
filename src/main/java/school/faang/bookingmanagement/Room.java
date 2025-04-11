package school.faang.bookingmanagement;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Set;

/*
 * Related to JIRA ticket: BJS2-68742
 * */
@RequiredArgsConstructor
@Setter
@Getter
@EqualsAndHashCode(of = "roomNumber")
public class Room {
    private final int roomNumber; // предпологаю,что roomNumber уникален
    private String type;
    private Set<String> amenities;
}
