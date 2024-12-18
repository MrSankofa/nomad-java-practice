package review.dependencyInjection;

public class SonyMonitor implements Monitor {

  @Override
  public void brightness(int brightness) {
    System.out.println("Brighten");

  }
}
