package com.company.FinalProject.Crypto;

import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Scanner;

public class CryptoAPI {

    public static String userCryptoInput(){
        System.out.println("Enter cryptocurrency symbol here: ");
        Scanner myScanner = new Scanner(System.in);
        String userData = myScanner.nextLine();
        return userData;
    }

    public static CryptoResponse getCoinPrice(String URI) {
        WebClient client = WebClient.create(URI);
        CryptoResponse cryptoResponse = null;

        //API try request
        try {
            Mono<CryptoResponse[]> response = client
                    .get()
                    .retrieve()
                    .bodyToMono(CryptoResponse[].class);

            cryptoResponse = response.share().block()[0];
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
        return cryptoResponse;
    }

    public static void cryptoDisplay(CryptoResponse cryptoResponse){
        if (cryptoResponse == null){
            System.out.println("Error: Invalid currency value, please try again using the symbols BTC or ETH.");
            return;
        }
        System.out.println("Cryptocurrency name: " + cryptoResponse.name);
        System.out.println("Cryptocurrency symbol: " + cryptoResponse.asset_id);
        System.out.println("Current price of cryptocurrency: " + "USD: $" + String.format("%.2f", + cryptoResponse.price_usd));
    }

}
