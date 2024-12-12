package review.dependencyInjection;


// Object composition - it's composed of other objects
// Class composition
public class Computer {

  // Tight Coupling
  private SonyMonitor monitor;
  private WDHarddrive hardDrive;

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
