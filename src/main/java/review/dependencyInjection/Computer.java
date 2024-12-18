package review.dependencyInjection;


// Object composition - it's composed of other objects
// Class composition
public class Computer {

  // Tight Coupling to Loose Coupling - code to abstractions or interfaces,
  // no works with any class that implements or extends a Monitor or a Hard Drive
  private Monitor monitor;
  private HardDrive hardDrive;

  // monitor and hard drive are dependencies of a computer
  // i.e. a computer depends on a monitor and a hard drive
  public Computer(Monitor monitor, HardDrive hardDrive) {
    // this is construction injection
    this.monitor = monitor;
    this.hardDrive = hardDrive;
  }

  public Monitor getMonitor() {
    return monitor;
  }

  // this is setter injection
  public void setMonitor(Monitor monitor) {
    this.monitor = monitor;
  }

  public HardDrive getHardDrive() {
    return hardDrive;
  }

  public void setHardDrive(HardDrive hardDrive) {
    this.hardDrive = hardDrive;
  }
}
