package com.company.FinalProject.ISS;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

public class IssAPI {

    //Method for ISS location
    public static IssResponse locateIss(){

        //Iss URI
        String issURI = "http://api.open-notify.org/iss-now.json";
        WebClient client = WebClient.create(issURI);
        IssResponse issResponse = null;

        //API try request
        try {
            Mono<IssResponse> response = client
                    .get()
                    .retrieve()
                    .bodyToMono(IssResponse.class);

            issResponse = response.share().block();
        }
        catch (WebClientResponseException we) {
            int statusCode = we.getRawStatusCode();
            if (statusCode >= 400 && statusCode < 500) {
                System.out.println("Client Error");
            } else if (statusCode >= 500 && statusCode < 600) {
                System.out.println("Server Error");
            }
            System.out.println(we.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return issResponse;
    }
}
