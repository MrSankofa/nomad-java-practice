package src.main.exercises.weather;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class WeatherTrackerCSV {


  public static void main(String[] args){
    // Store one month's worth of data here
    ArrayList<DailyWeatherData> weatherData = new ArrayList<DailyWeatherData>();

    String filePath = "src/main/exercises/weather/weather.csv";

    try(BufferedReader br = new BufferedReader(new FileReader(filePath))){

      String line;

      while((line = br.readLine()) != null){
        String[] data = line.split(",");

        System.out.println("Data: " + Arrays.toString(data));

        mapToDailyWeatherData(data, weatherData);
      }


//      calcAvgTemps(weatherData);
//      calcAvgPressure(weatherData);
//      calcAvgRainfall(weatherData);
//      calcHumidity(weatherData);
//      calcWindSpeed(weatherData);
//      calcMaxMinHighTemp(weatherData);
//      calcMaxMinLowTemp(weatherData);
      calcMostFreqWindDirection(weatherData);


    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  static void calcMostFreqWindDirection(ArrayList<DailyWeatherData> data) {

    // count the wind direction frequency
    Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

     for( DailyWeatherData d : data) {
       frequencyMap.put(d.windDirection, frequencyMap.getOrDefault(d.windDirection, 0) + 1);
     }

     // find the highest, TODO: what if they are all unique?
     Integer highestFrequencyDirection = 0;
     ArrayList<Integer> mostCommonWindDirection = new ArrayList<>();

     for( Map.Entry<Integer, Integer> entry : frequencyMap.entrySet() ) {
       if(entry.getValue() > highestFrequencyDirection) {
         highestFrequencyDirection = entry.getValue();
         mostCommonWindDirection.clear();
         mostCommonWindDirection.add(entry.getKey());
       } else if ( entry.getValue() == highestFrequencyDirection) {
         mostCommonWindDirection.add(entry.getKey());
       }

     }

     if(mostCommonWindDirection.size() == 0) {
       System.out.println("\n No Data");
     } else {
      System.out.println("\nThe most common wind direction is/are " + mostCommonWindDirection + " degrees. Showing " + highestFrequencyDirection + " times");
     }



  }

  static void calcMaxMinLowTemp(ArrayList<DailyWeatherData> data) {

  }
  static void calcMaxMinHighTemp(ArrayList<DailyWeatherData> data) {

  }

  static void calcWindSpeed(ArrayList<DailyWeatherData> data) {

  }
  static void calcHumidity(ArrayList<DailyWeatherData> data) {

  }

  static void calcAvgRainfall(ArrayList<DailyWeatherData> data) {

  }
  static void calcAvgPressure(ArrayList<DailyWeatherData> data) {

  }

  static void calcAvgTemps(ArrayList<DailyWeatherData> data) {

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