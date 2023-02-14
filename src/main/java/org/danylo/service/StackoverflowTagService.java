package org.danylo.service;

import org.danylo.api.StackoverflowApi;
import org.danylo.model.StackoverflowResponse;
import org.danylo.model.StackoverflowTag;
import org.danylo.model.StackoverflowUser;
import retrofit2.Call;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StackoverflowTagService extends StackoverflowService {
    public static final List<String> DESIRED_TAGS = List.of("java", ".net", "docker", "c#");
    private static final String FILTER = "!T.BkwD0bGAK_*fEV84";

    public void setTagsToUsers(StackoverflowApi stackoverflowApi, List<StackoverflowUser> users) {
        for (StackoverflowUser user : users) {
            List<StackoverflowTag> tags = callStackoverflowApi(stackoverflowApi, user.getId());
            user.setTags(tags);
        }
    }

    public List<StackoverflowUser> filterUsers(List<StackoverflowUser> users) {
        return users.stream()
                .filter(user -> user.getTags() != null &&
                        user.getTags().stream().anyMatch(tag -> DESIRED_TAGS.stream().anyMatch(desiredTag -> desiredTag.equals(tag.getName()))))
                .collect(Collectors.toList());
    }

    private List<StackoverflowTag> callStackoverflowApi(StackoverflowApi stackoverflowApi, String userId) {
        Map<String, String> queryParameters = Map.of(
                "site", SITE,
                "filter", FILTER,
                "pageSize", PAGE_SIZE
        );
        Call<StackoverflowResponse<StackoverflowTag>> call = stackoverflowApi.getUserTags(userId, queryParameters);
        return getResponseBody(call);
    }
}
