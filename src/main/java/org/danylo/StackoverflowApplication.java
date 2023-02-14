package org.danylo;

import org.danylo.utils.StackoverflowUsersReceivingFacade;

public class StackoverflowApplication {
    public static void main(String[] args) {
        StackoverflowUsersReceivingFacade facade = new StackoverflowUsersReceivingFacade();
        facade.receiveUsers();
    }
}
