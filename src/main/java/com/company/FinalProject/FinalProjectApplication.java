package com.company.FinalProject;

import com.company.FinalProject.Crypto.CryptoAPI;
import com.company.FinalProject.Crypto.CryptoResponse;
import com.company.FinalProject.ISS.IssAPI;
import com.company.FinalProject.Weather.WeatherAPI;
import com.company.FinalProject.Weather.WeatherResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

import static com.company.FinalProject.Crypto.CryptoAPI.getCoinPrice;
import static com.company.FinalProject.Crypto.CryptoAPI.userCryptoInput;

@SpringBootApplication
public class FinalProjectApplication {

	public static void main(String[] args) {

		SpringApplication.run(FinalProjectApplication.class, args);

		Scanner myScanner = new Scanner(System.in);
		String userInput = myScanner.nextLine();
		int userOption;

		do {
			//Menu
			System.out.println("Menu");
			System.out.println(" ");
			System.out.println("Please select an option from the menu below: ");
			System.out.println(" ");
			System.out.println("1. Local Weather");
			System.out.println("2. ISS Location");
			System.out.println("3. Weather at ISS Location");
			System.out.println("4. Cryptocurrency Prices");
			System.out.println("5. Exit");


			try {
				userInput = myScanner.nextLine();
				userOption = Integer.parseInt(myScanner.nextLine());

				switch (userOption) {
					case 1:
						localWeather();
						break;
					case 2:
						issLocation();
						break;
					case 3:
						weatherAtIss();
						break;
					case 4:
						cryptoPrices();
						break;
					case 5:
						System.out.println("Exiting App... Goodbye!");
						break;
					default:
						System.out.println("Error: Please enter valid menu option.");
				}

			} catch (NumberFormatException e) {
				userOption = 0;
			}
			if (userOption < 1 || userOption > 5) {
				System.out.println("Invalid selection, please enter an integer in between 1-5");
			}
		} while (userOption != 5);
		return;

	}

	// Method for local weather by user input
	private static void localWeather() {
		System.out.println(WeatherAPI.userCity());
		String URI = WeatherAPI.weatherUserCity();
		WeatherResponse weather = WeatherAPI.getWeatherResponse(URI);

		if (weather == null) {
			System.out.println("Error: City not found, please try again.");
			WeatherAPI.userCity();
			URI = WeatherAPI.weatherUserCity();
			WeatherAPI.getWeatherResponse(URI);
		}
	}

	//Method for ISS Location
	private static void issLocation() {
		System.out.println("Locating ISS... " + IssAPI.locateIss());
		IssAPI issURI = new IssAPI();
		if (issURI == null) {
			System.out.println("Error: Reloading... ");
			IssAPI.locateIss();
		}
	}

	//Method for weather at ISS Location
	private static void weatherAtIss() {
		System.out.println("Weather at ISS: " + WeatherAPI.weatherIssLocation());
		IssAPI issURI = new IssAPI();
		if (issURI == null) {
			System.out.println("Error: Reloading... ");
			IssAPI.locateIss();
		}
	}

	//Method for Crypto Prices
	public static void cryptoPrices() {
		//Crypto URI
		String asset_id = userCryptoInput();
		String apiKey = "802E149A-0965-4450-BD31-7A73C51867C6";
		String coinLink = "https://rest.coinapi.io/v1/assets/" + asset_id + apiKey;
		CryptoResponse cryptoResponse = getCoinPrice(coinLink);
		CryptoAPI.cryptoDisplay(cryptoResponse);

	}
}
