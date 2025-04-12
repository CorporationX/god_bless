package school.faang.lambdas.moderator;

import school.faang.lambdas.Notification;

import java.util.function.Predicate;

public record Rule(String name, String description, Predicate<Notification> check) {
}