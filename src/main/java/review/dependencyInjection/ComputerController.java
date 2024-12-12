package review.dependencyInjection;

public class ComputerController {

  public static void main(String[] args) {
    SonyMonitor monitor = new SonyMonitor();
    WDHarddrive harddrive = new WDHarddrive();

    Computer computer = new Computer(monitor, harddrive);

    computer.getHardDrive().saveDisk();
    computer.getMonitor().brighten();

  }
}
