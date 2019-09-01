package honeycrisp.robot;

import java.util.List;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import honeycrisp.cmdutils.CommandDirectory;
import honeycrisp.cmdutils.OI;
import honeycrisp.subsystems.HCSubsystem;

public abstract class HCRobot extends TimedRobot{
    private List<HCSubsystem> subsystems;
    private OI oi;
    private CommandDirectory commandDirectory;
    private Command autonomousCommand;
    private SendableChooser<Command> chooser;

    @Override
    public void robotInit() {
      commandDirectory = new CommandDirectory();
      subsystems = createSubsystems();
      chooser = new SendableChooser<>();
      subsystems.forEach(sub -> sub.addCommands(commandDirectory));
      populateSendableChooser(commandDirectory, chooser);
    }

    @Override
    public void robotPeriodic() {
      subsystems.forEach(sub -> sub.updateSmartDashboardValues());
    }

    @Override
    public void disabledInit() {
    }
  
    @Override
    public void disabledPeriodic() {
      Scheduler.getInstance().run();
    }

    @Override
    public void autonomousInit() {
      autonomousCommand = getAutonomousCommand(chooser);
  
      /*
       * String autoSelected = SmartDashboard.getString("Auto Selector",
       * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
       * = new MyAutoCommand(); break; case "Default Auto": default:
       * autonomousCommand = new ExampleCommand(); break; }
       */
  
      // schedule the autonomous command (example)
      if (autonomousCommand != null) {
        autonomousCommand.start();
      }
    }

    @Override
    public void autonomousPeriodic() {
      Scheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {
      // This makes sure that the autonomous stops running when
      // teleop starts running. If you want the autonomous to
      // continue until interrupted by another command, remove
      // this line or comment it out.
      if (autonomousCommand != null) {
        autonomousCommand.cancel();
      }
    }

    @Override
    public void teleopPeriodic() {
      Scheduler.getInstance().run();
    }

    @Override
    public void testPeriodic() {
    }

    protected abstract List<HCSubsystem> createSubsystems();
    protected abstract Command getAutonomousCommand(SendableChooser<Command> chooser);
    protected abstract void populateSendableChooser(CommandDirectory commandDirectory, SendableChooser<Command> chooser);
}