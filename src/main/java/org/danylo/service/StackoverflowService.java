package org.danylo.service;

import edu.princeton.cs.introcs.StdOut;
import org.danylo.model.StackoverflowResponse;
import retrofit2.Call;
import retrofit2.Response;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class StackoverflowService {
    protected static final String SITE = "stackoverflow";
    protected static final String PAGE_SIZE = "100";

    protected  <T> List<T> getResponseBody(Call<StackoverflowResponse<T>> call) {
        Response<StackoverflowResponse<T>> response = null;
        try {
            response = call.execute();
        } catch (IOException e) {
            StdOut.println("A problem occurred talking to the server.");
        }
        return response == null || response.body() == null ? Collections.emptyList() : response.body().getItems();
    }
}
