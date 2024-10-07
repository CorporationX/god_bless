package school.faang.godbless.bjs2_33231;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StreamEventsTest {

  private StreamEventsSystem system;

  @BeforeEach
  public void init() {
    this.system = new StreamEventsSystem();
  }

  @Test
  void testAddStreamEvent() {
    StreamEvent event = new StreamEvent(1, "Subscription", "User Vasya subscribed to tou");

    system.addStreamEvent(event);

    assertTrue(system.getById(event.getId()).isPresent());
    assertEquals(event, system.getById(event.getId()).get());
    assertTrue(system.getByType(event.getEventType()).isPresent());
    assertEquals(event, system.getByType(event.getEventType()).get().get(0));
  }

  @Test
  void testGetByType() {
    StreamEvent event1 = new StreamEvent(1, "Subscription", "User Vasya subscribed to Petya");
    StreamEvent event2 = new StreamEvent(2, "Like", "User Vasya liked post");
    StreamEvent event3 = new StreamEvent(3, "Subscription", "User Petya subscribed to Vasya");

    system.addStreamEvent(event1);
    system.addStreamEvent(event2);
    system.addStreamEvent(event3);

    Optional<List<StreamEvent>> actual = system.getByType("Subscription");

    assertTrue(actual.isPresent());
    assertEquals(2, actual.get().size());
    actual.get().remove(event1);
    actual.get().remove(event3);
    assertEquals(0, actual.get().size());
  }

  @Test
  void testRemoveByExistingId() {
    StreamEvent event1 = new StreamEvent(1, "Subscription", "User Vasya subscribed to Petya");
    StreamEvent event2 = new StreamEvent(2, "Like", "User Vasya liked post");
    StreamEvent event3 = new StreamEvent(3, "Subscription", "User Petya subscribed to Vasya");

    system.addStreamEvent(event1);
    system.addStreamEvent(event2);
    system.addStreamEvent(event3);

    system.removeById(1);

    assertTrue(system.getById(1).isEmpty());
  }

  @Test
  void testGetEventsAsString() {
    StreamEvent event1 = new StreamEvent(1, "Subscription", "User Vasya subscribed to Petya");
    StreamEvent event2 = new StreamEvent(2, "Like", "User Vasya liked post");
    StreamEvent event3 = new StreamEvent(3, "Subscription", "User Petya subscribed to Vasya");

    system.addStreamEvent(event1);
    system.addStreamEvent(event2);
    system.addStreamEvent(event3);

    String actual = system.getEventsAsString();
    assertEquals("StreamEvent(id=1, eventType=Subscription, data=User Vasya subscribed to Petya)"
        + "StreamEvent(id=2, eventType=Like, data=User Vasya liked post)"
        + "StreamEvent(id=3, eventType=Subscription, data=User Petya subscribed to Vasya)", actual);
  }
}