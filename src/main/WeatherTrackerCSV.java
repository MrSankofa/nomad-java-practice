package src.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class WeatherTrackerCSV {

  public static void main(String[] args){
    // Store one month's worth of data here
    ArrayList<DailyWeatherData> weatherData = new ArrayList<DailyWeatherData>();

    String filePath = "src/main/weather.csv";

    try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

      String line;

      while((line = br.readLine()) != null){
        String[] data = line.split(",");

        System.out.println("Data: " + Arrays.toString(data));

        mapToDailyWeatherData(data, weatherData);
      }

      for (int i=1; i<weatherData.size(); i++){
        // Create an object to store the data
        DailyWeatherData singleDayWeatherData = weatherData.get(i);

        System.out.println("Enter weather data for day #" + i);
        System.out.println("------------------------------");

        System.out.print("High temperature: ");
        System.out.println(singleDayWeatherData.highTemp);

        System.out.print("Low temperature: ");
        System.out.println(singleDayWeatherData.lowTemp);

        System.out.print("Rainfall in inches: ");
        System.out.println(singleDayWeatherData.rainfall);

        System.out.print("Humidity from 0.0 - 1.0: ");
        System.out.println(singleDayWeatherData.humidity);

        System.out.print("Barometric pressure: ");
        System.out.println(singleDayWeatherData.pressure);

        System.out.print("Wind Speed: ");
        System.out.println(singleDayWeatherData.windSpeed);

        System.out.print("Wind Direction in degrees: ");
        System.out.println(singleDayWeatherData.windDirection);

      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void mapToDailyWeatherData(String[] data, ArrayList<DailyWeatherData> list) {
    if(data.length > 0 && !data[0].equals("highTemp")){
      int highTemp = Integer.parseInt(data[0]);
      int lowTemp = Integer.parseInt(data[1]);
      double rainfall = Double.parseDouble(data[2]);
      double humidity = Double.parseDouble(data[3]);
      double pressure = Double.parseDouble(data[4]);
      int windSpeed = Integer.parseInt(data[5]);
      int windDirection = Integer.parseInt(data[6]);

      list.add(new DailyWeatherData(highTemp, lowTemp, rainfall, humidity, pressure, windSpeed, windDirection));

    }


  }
}