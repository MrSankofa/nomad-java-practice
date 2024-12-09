package src.main.exercises.weather;

import java.util.Scanner;

public class WeatherTracker{

  public static void main(String[] args){
    // Store one month's worth of data here
    DailyWeatherData[] weatherData = new DailyWeatherData[30];

    // Create a scanner to get user input
    Scanner scanner = new Scanner(System.in);

    for (int i=0; i<weatherData.length; i++){
      // Create an object to store the data
      DailyWeatherData
          singleDayWeatherData = new DailyWeatherData();

      System.out.println("Enter weather data for day #" + i);
      System.out.println("------------------------------");

      System.out.print("High temperature: ");
      singleDayWeatherData.highTemp = scanner.nextInt();

      System.out.print("Low temperature: ");
      singleDayWeatherData.lowTemp = scanner.nextInt();

      System.out.print("Rainfall in inches: ");
      singleDayWeatherData.rainfall = scanner.nextDouble();

      System.out.print("Humidity from 0.0 - 1.0: ");
      singleDayWeatherData.humidity = scanner.nextDouble();

      System.out.print("Barometric pressure: ");
      singleDayWeatherData.pressure = scanner.nextDouble();

      System.out.print("Wind Speed: ");
      singleDayWeatherData.windSpeed = scanner.nextInt();

      System.out.print("Wind Direction in degrees: ");
      singleDayWeatherData.windDirection = scanner.nextInt();

      // Store the data in the array
      weatherData[i] = singleDayWeatherData;
    }
  }
}