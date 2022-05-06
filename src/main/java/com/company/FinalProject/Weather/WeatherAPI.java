package com.company.FinalProject.Weather;

import com.company.FinalProject.ISS.IssCoordinates;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Scanner;

public class WeatherAPI {

    //method for user's city
    public static String userCity(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type city here: ");
        return scanner.nextLine();
    }

    //Weather URI by user city
    public static String weatherUserCity(){
        String cityName = userCity();
        String apiKey = "5a5b62808ec829bf95a5338109de9cc2";
        return "https://api.openweathermap.org/data/2.5/weather?q=" + cityName + apiKey;
    }

    //Weather URI by ISS Location
    public static String weatherIssLocation(){
        IssCoordinates latitude = new IssCoordinates();
        IssCoordinates longitude = new IssCoordinates();
        String apiKey = "5a5b62808ec829bf95a5338109de9cc2";
        return "https://api.openweathermap.org/data/2.5/weather?q=" + latitude + "&lon=" + longitude + "&appid=" + apiKey;
    }

    public static WeatherResponse getWeatherResponse(String URI1){
        WebClient client = WebClient.create(URI1);
        WeatherResponse weatherResponse = null;

        //API try request
        try {
            Mono<WeatherResponse> response = client
                    .get()
                    .retrieve()
                    .bodyToMono(WeatherResponse.class);

            weatherResponse = response.share().block();
        }
        catch (WebClientResponseException we){
            int statusCode = we.getRawStatusCode();
            if (statusCode >= 400 && statusCode < 500){
                System.out.println("Client Error");
            }
            else if (statusCode >= 500 && statusCode <= 600){
                System.out.println("Server Error");
            }
            System.out.println(we.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return weatherResponse;
    }
}
