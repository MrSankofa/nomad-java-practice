package review.dependencyInjection;


// Object composition - it's composed of other objects
// Class composition
public class Computer {

  // Tight Coupling
  private SonyMonitor monitor;
  private WDHarddrive hardDrive;
  private AsusHardDrive asusHardDrive; // does a computer have to distinct hard drives? What if we need to change the monitor and hard drives for a 100 different kinds


  public Computer(SonyMonitor monitor, WDHarddrive hardDrive) {
    this.monitor = monitor;
    this.hardDrive = hardDrive;
  }

  public SonyMonitor getMonitor() {
    return monitor;
  }

  public void setMonitor(SonyMonitor monitor) {
    this.monitor = monitor;
  }

  public WDHarddrive getHardDrive() {
    return hardDrive;
  }

  public void setHardDrive(WDHarddrive hardDrive) {
    this.hardDrive = hardDrive;
  }
}
