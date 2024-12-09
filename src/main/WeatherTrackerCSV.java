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

//        weatherData.add(map())
      }

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }


  }
}