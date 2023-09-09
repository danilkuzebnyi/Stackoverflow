package org.danylo.utils;

import edu.princeton.cs.introcs.StdOut;
import org.danylo.api.StackoverflowApi;
import org.danylo.model.StackoverflowUser;
import org.danylo.service.StackoverflowTagService;
import org.danylo.service.StackoverflowUserService;
import java.util.List;

public class StackoverflowUsersReceivingFacade {
    private static final int NUMBER_OF_PAGES = 10;
    private final StackoverflowUserService stackoverflowUserService;
    private final StackoverflowTagService stackoverflowTagService;

    public StackoverflowUsersReceivingFacade() {
        this.stackoverflowUserService = new StackoverflowUserService();
        this.stackoverflowTagService = new StackoverflowTagService();
    }

    public void receiveUsers() {
        StdOut.println("Starting extracting users from the given criteria...\n");
        StackoverflowApi stackoverflowApi = StackoverflowApi.getApi();
        List<StackoverflowUser> users = stackoverflowUserService.getUsers(stackoverflowApi, NUMBER_OF_PAGES);
        stackoverflowTagService.setTagsToUsers(stackoverflowApi, users);
        List<StackoverflowUser> resultUsers = stackoverflowTagService.filterUsers(users);
        stackoverflowUserService.printUsers(resultUsers);
    }
}
