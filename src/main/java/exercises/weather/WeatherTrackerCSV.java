package exercises.weather;

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

      System.out.println("\nthe average high temp is: " + calcAvgHighTemps(weatherData));
      System.out.println("the average low temp is: " + calcAvgLowTemps(weatherData));
      System.out.println("the average pressure is: " + calcAvgPressure(weatherData));
      System.out.println("the average rainfall is: " + calcAvgRainfall(weatherData));
      System.out.println("the average humdity is: " + calcAvgHumidity(weatherData));

      ;

      calcAvgPressure(weatherData);
      calcAvgRainfall(weatherData);
      calcAvgHumidity(weatherData);
      calcMaxMinWindSpeed(weatherData);
      calcMaxMinHighTemp(weatherData);
      calcMaxMinLowTemp(weatherData);
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
    Integer lowestLowTemp = Integer.MAX_VALUE;
    Integer highestLowTemp = Integer.MIN_VALUE;

    for( DailyWeatherData d : data) {
      if(d.lowTemp < lowestLowTemp) {
        lowestLowTemp = d.lowTemp;
      }

      if(d.lowTemp > highestLowTemp) {
        highestLowTemp = d.lowTemp;
      }
    }

    if ( lowestLowTemp != Integer.MAX_VALUE) {
      System.out.println("\nMax low temp is " + highestLowTemp);
      System.out.println("Min low temp is " + lowestLowTemp);
    } else {

      System.out.println("\n No Data");
    }

  }
  static void calcMaxMinHighTemp(ArrayList<DailyWeatherData> data) {
    Integer lowestHighTemp = Integer.MAX_VALUE;
    Integer highestHighTemp = Integer.MIN_VALUE;

    for( DailyWeatherData d : data) {
      if(d.highTemp < lowestHighTemp) {
        lowestHighTemp = d.highTemp;
      }

      if(d.highTemp > highestHighTemp) {
        highestHighTemp = d.highTemp;
      }
    }

    if ( lowestHighTemp != Integer.MAX_VALUE) {
      System.out.println("\nMax high temp is " + highestHighTemp);
      System.out.println("Min high temp is " + lowestHighTemp);
    } else {

      System.out.println("\n No Data");
    }
  }

  static void calcMaxMinWindSpeed(ArrayList<DailyWeatherData> data) {
    Integer lowestWindSpeed = Integer.MAX_VALUE;
    Integer highestWindSpeed = Integer.MIN_VALUE;

    for( DailyWeatherData d : data) {
      if(d.windSpeed < lowestWindSpeed) {
        lowestWindSpeed = d.windSpeed;
      }

      if(d.windSpeed > highestWindSpeed) {
        highestWindSpeed = d.windSpeed;
      }
    }

    if ( lowestWindSpeed != Integer.MAX_VALUE) {
      System.out.println("\nMax wind speed is " + highestWindSpeed);
      System.out.println("Min wind speed is " + lowestWindSpeed);
    } else {

      System.out.println("\n No Data");
    }
  }


  static Double calcAvgHumidity(ArrayList<DailyWeatherData> data) {
    Double sum = data.stream().mapToDouble(d -> d.humidity).sum();
    return sum / data.size();
  }

  static Double calcAvgRainfall(ArrayList<DailyWeatherData> data) {
    Double sum = data.stream().mapToDouble(d -> d.rainfall).sum();
    return sum / data.size();
  }
  static Double calcAvgPressure(ArrayList<DailyWeatherData> data) {
    Double sum = data.stream().mapToDouble(d -> d.pressure).sum();
    return sum / data.size();
  }

  static int calcAvgHighTemps(ArrayList<DailyWeatherData> data) {
    int sum = data.stream().mapToInt(d -> d.highTemp).sum();
    return sum / data.size();
  }

  static int calcAvgLowTemps(ArrayList<DailyWeatherData> data) {
    int sum = data.stream().mapToInt(d -> d.lowTemp).sum();
    return sum / data.size();
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