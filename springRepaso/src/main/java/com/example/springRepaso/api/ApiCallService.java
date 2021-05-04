package com.example.springRepaso.api;

import com.google.gson.Gson;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.rmi.RemoteException;

@Service
@Slf4j
public class ApiCallService {

    @CircuitBreaker(name = "chuckNorris",fallbackMethod = "fallback")
    public  ChuckNorrisResponse getChuckNorris() throws IOException, InterruptedException {

        if(RandomUtils.nextBoolean())
        {
        throw new RemoteException("");
        }

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://matchilling-chuck-norris-jokes-v1.p.rapidapi.com/jokes/random"))
                .header("accept", "application/json")
                .header("x-rapidapi-key", "e2969ed41fmsh2ab5942f65befeep15f423jsncfa83f20a2e0")
                .header("x-rapidapi-host", "matchilling-chuck-norris-jokes-v1.p.rapidapi.com")
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());

        return new Gson().fromJson(response.body(),ChuckNorrisResponse.class);
    }
    public  ChuckNorrisResponse fallback(final Throwable t ){
        log.info("Fallback cause, {}",t.toString());
        return ChuckNorrisResponse.builder().build();
    }

}
