package school.faang.bjs2_88130.user_action;

import java.time.Month;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Collectors;

import school.faang.bjs2_88130.user_action.UserAction.ActionType;
import school.faang.bjs2_88130.exception.HashtagsNotFoundException;
import school.faang.bjs2_88130.exception.ActionTypeNotFoundException;

public class UserActionAnalyzer {
    private UserActionAnalyzer() {
    }

    public static List<String> makeTopActiveUsers(List<UserAction> usersActions, int quantity) {
        ensureUsersActionsAndQuantityValid(usersActions, quantity);

        return usersActions.stream()
                .filter(Objects::nonNull)
                .collect(Collectors.groupingBy(UserAction::getUserId))
                .entrySet().stream()
                .sorted((firstUserActions, secondUserActions) ->
                        secondUserActions.getValue().size() - firstUserActions.getValue().size())
                .map(pair -> pair.getValue().get(0).getUserName())
                .limit(quantity)
                .toList();
    }

    public static List<String> makeTopPopularHashtags(List<UserAction> usersActions, int quantity) {
        ensureUsersActionsValid(usersActions);
        ensureHashtagsExist(usersActions, quantity);

        return usersActions.stream()
                .filter(userAction -> userAction.getContent().contains("#"))
                .collect(Collectors.groupingBy(
                        userAction -> {
                            String content = userAction.getContent();
                            int indexOfHashtag = content.indexOf("#");
                            String hashtag = "";
                            for (int i = indexOfHashtag + 1; i < content.length(); i++) {
                                if (!Character.isAlphabetic(content.charAt(i))) {
                                    hashtag = content.substring(indexOfHashtag, i);
                                    break;
                                } else if (Character.isAlphabetic(content.charAt(i))
                                        && i == content.length() - 1) {
                                    hashtag = content.substring(indexOfHashtag, i + 1);
                                    break;
                                }
                            }
                            return hashtag;
                        }
                ))
                .entrySet().stream()
                .sorted((firstTag, secondTag) ->
                        secondTag.getValue().size() - firstTag.getValue().size())
                .map(Map.Entry::getKey)
                .limit(quantity)
                .toList();
    }

    public static List<String> makeTopCommentersLastMonth(List<UserAction> usersActions, int quantity) {
        ensureUsersActionsAndQuantityValid(usersActions, quantity);
        ensureActionTypeExists(usersActions, ActionType.COMMENT);

        Month lastMonth = usersActions.stream()
                .filter(userAction -> userAction.getActionType() == ActionType.COMMENT)
                .map(userAction -> userAction.getActionDate().getMonth())
                .max(Comparator.comparingInt(Month::getValue))
                .orElseThrow(() -> new NoSuchElementException(
                        "cannot find the last month - user activities list is empty or elements are null"
                ))
                .minus(1);

        return usersActions.stream()
                .filter(Objects::nonNull)
                .filter(userAction -> {
                    Month actionDateMonth = userAction.getActionDate().getMonth();
                    ActionType actionType = userAction.getActionType();
                    return actionDateMonth == lastMonth && actionType == ActionType.COMMENT;
                })
                .collect(Collectors.groupingBy(UserAction::getUserId))
                .entrySet().stream()
                .sorted((firstUserComments, secondUserComments) ->
                        secondUserComments.getValue().size() - firstUserComments.getValue().size())
                .map(keyById -> keyById.getValue().get(0).getUserName())
                .limit(quantity)
                .toList();
    }

    public static String findPercentageOfAction(List<UserAction> usersActions, ActionType actionType) {
        ensureActionTypeExists(usersActions, actionType);
        return calculatePercentageOfAction(usersActions, actionType);
    }

    public static String findPercentagesOfActions(List<UserAction> usersActions) {
        ensureAllActionTypesExist(usersActions);
        return calculatePercentagesOfActions(usersActions);
    }

    private static String calculatePercentageOfAction(List<UserAction> usersActions, ActionType actionType) {
        int allActionsQuantity = usersActions.size();

        return String.format("%.2f%%", ((double) usersActions.stream()
                .map(UserAction::getActionType)
                .filter(type -> type == actionType)
                .count() / allActionsQuantity * 100));
    }

    private static String calculatePercentagesOfActions(List<UserAction> usersActions) {
        String likePercentage = calculatePercentageOfAction(usersActions, ActionType.LIKE);
        String postPercentage = calculatePercentageOfAction(usersActions, ActionType.POST);
        String commentPercentage = calculatePercentageOfAction(usersActions, ActionType.COMMENT);
        String sharePercentage = calculatePercentageOfAction(usersActions, ActionType.SHARE);

        return String.format("посты - %s, комменты - %s, лайки - %s, репосты - %s",
                likePercentage, postPercentage, commentPercentage, sharePercentage);
    }

    private static void ensureUsersActionsAndQuantityValid(List<UserAction> usersActions, int quantity) {
        ensureUsersActionsValid(usersActions);
        ensureUsersQuantityValid(quantity, usersActions.size());
    }

    private static void ensureUsersActionsValid(List<UserAction> usersActions) {
        if (usersActions == null || usersActions.isEmpty()) {
            throw new IllegalArgumentException("users actions list must be full");
        }
    }

    private static void ensureUsersQuantityValid(int quantity, int usersActions) {
        if (quantity <= 0 || quantity > usersActions) {
            throw new IllegalArgumentException(
                    "quantity of users actions cannot be negative and cannot be greater than size of the list"
            );
        }
    }

    private static void ensureHashtagsExist(List<UserAction> usersActions, int quantity) {
        List<String> usersContents = usersActions.stream()
                .map(UserAction::getContent)
                .filter(userAction -> userAction.contains("#"))
                .toList();

        int hashtagsCounter = 0;
        for (String userContent : usersContents) {
            if (userContent.contains("#")) {
                hashtagsCounter++;
            }
        }

        if (hashtagsCounter == 0) {
            throw new HashtagsNotFoundException("no hashtags were found in the users actions list");
        } else if (quantity > hashtagsCounter) {
            throw new IllegalArgumentException(
                    "the quantity of requested hashtags is greater than the number in the list"
            );
        }
    }

    private static void ensureActionTypeExists(List<UserAction> usersActions, ActionType actionType) {
        List<ActionType> actionTypes = usersActions.stream()
                .map(UserAction::getActionType)
                .toList();

        if (!actionTypes.contains(actionType)) {
            throw new ActionTypeNotFoundException(
                    String.format("%s does not exist in the users actions list", actionType)
            );
        }
    }

    private static void ensureAllActionTypesExist(List<UserAction> usersActions) {
        ensureActionTypeExists(usersActions, ActionType.LIKE);
        ensureActionTypeExists(usersActions, ActionType.POST);
        ensureActionTypeExists(usersActions, ActionType.COMMENT);
        ensureActionTypeExists(usersActions, ActionType.SHARE);
    }
}
