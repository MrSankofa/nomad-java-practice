package src.main;

public class DailyWeatherData{
  // Track high and low temperatures
  public int highTemp;
  public int lowTemp;

  // Total rainfall in inches
  public double rainfall;

  // Humidity as a percentage
  public double humidity;

  // Barometric pressure
  public double pressure;

  // Wind speed and direction in degrees
  public int windSpeed;
  public int windDirection;

  // Add constructor, getters, and setters here
  public DailyWeatherData() {}

  public DailyWeatherData(int highTemp, int lowTemp, double rainfall, double humidity, double pressure, int windSpeed, int windDirection) {
    this.highTemp = highTemp;
    this.lowTemp = lowTemp;
    this.rainfall = rainfall;
    this.humidity = humidity;
    this.pressure = pressure;
    this.windSpeed = windSpeed;
    this.windDirection = windDirection;
  }

  public int getHighTemp() {
    return highTemp;
  }

  public void setHighTemp(int highTemp) {
    this.highTemp = highTemp;
  }

  public int getLowTemp() {
    return lowTemp;
  }

  public void setLowTemp(int lowTemp) {
    this.lowTemp = lowTemp;
  }

  public double getRainfall() {
    return rainfall;
  }

  public void setRainfall(double rainfall) {
    this.rainfall = rainfall;
  }

  public double getHumidity() {
    return humidity;
  }

  public void setHumidity(double humidity) {
    this.humidity = humidity;
  }

  public double getPressure() {
    return pressure;
  }

  public void setPressure(double pressure) {
    this.pressure = pressure;
  }

  public int getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(int windSpeed) {
    this.windSpeed = windSpeed;
  }

  public int getWindDirection() {
    return windDirection;
  }

  public void setWindDirection(int windDirection) {
    this.windDirection = windDirection;
  }

}
