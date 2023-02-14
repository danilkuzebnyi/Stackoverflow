package org.danylo.service;

import edu.princeton.cs.introcs.StdOut;
import org.danylo.api.StackoverflowApi;
import org.danylo.model.StackoverflowResponse;
import org.danylo.model.StackoverflowUser;
import retrofit2.Call;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StackoverflowUserService extends StackoverflowService {
    public static final int DESIRED_ANSWER_COUNT = 1;
    public static final int DESIRED_REPUTATION = 223;
    public static final List<String> DESIRED_LOCATIONS = List.of("Romania", "Moldova");
    private static final String FILTER = "!djXCWfao3PFLxAlHolhWoU7J";

    public List<StackoverflowUser> getUsers(StackoverflowApi stackoverflowApi, int numberOfPages) {
        List<StackoverflowUser> filteredUsers = new ArrayList<>();
        for (int pageNumber = 1; pageNumber <= numberOfPages; pageNumber++) {
            List<StackoverflowUser> users = callStackoverflowApi(stackoverflowApi, pageNumber);
            filteredUsers.addAll(filterUsers(users));
        }
        return filteredUsers;
    }

    public void printUsers(List<StackoverflowUser> users) {
        StdOut.println(users.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n\n")));
    }

    private List<StackoverflowUser> filterUsers(List<StackoverflowUser> users) {
        return users.stream()
                .filter(user -> user.getLocation() != null && DESIRED_LOCATIONS.stream().anyMatch(desiredLocation -> user.getLocation().contains(desiredLocation))
                        && Integer.parseInt(user.getAnswerCount()) >= DESIRED_ANSWER_COUNT
                        && Integer.parseInt(user.getReputation()) >= DESIRED_REPUTATION)
                .collect(Collectors.toList());
    }

    private List<StackoverflowUser> callStackoverflowApi(StackoverflowApi stackoverflowApi, int pageNumber) {
        Map<String, String> queryParameters = Map.of(
                "site", SITE,
                "filter", FILTER,
                "page", String.valueOf(pageNumber),
                "pageSize", PAGE_SIZE
        );
        Call<StackoverflowResponse<StackoverflowUser>> call = stackoverflowApi.getUsers(queryParameters);
        return getResponseBody(call);
    }
}
