package frc.robot;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.DriveTrainBuilder;
import frc.robot.subsystems.GamePadSubsystem;
import frc.robot.subsystems.GroupCommands;
import honeycrisp.cmdutils.CommandDirectory;
import honeycrisp.cmdutils.OI;
import honeycrisp.robot.HCRobot;
import honeycrisp.subsystems.HCSubsystem;

public class NextGenRobot extends HCRobot{
  // When creating the drive train, set the maximum output to this value.
  // The max output can be set directory on the DriveTrain from a drive train 
  // command. For example, the initliize method can set the max ouput in the initialize
  // method. Any drive train that does this, should set it back in the end()/interrupted() methods.
    private static double MAX_DRIVE_TRAIN_POWER = 1.0;

    @Override
    protected  List<HCSubsystem> createSubsystems(){
        ArrayList<HCSubsystem> subsystems = new ArrayList<>();
        OI oi = new OI(new XboxController(0));

        // chooser.addOption("My Auto", new MyAutoCommand());
    
        subsystems.add(createDriveTrainSubsystem());
        subsystems.add(createGroupCommandsSubsystem());
        subsystems.add(createGamePadSubsystem(oi));
        return subsystems;
    }

    @Override
    protected  Command getAutonomousCommand(SendableChooser<Command> chooser){
        return null;
    }

    @Override
    protected void populateSendableChooser(CommandDirectory commandDirectory, SendableChooser<Command> chooser){
                                
    }

    private HCSubsystem createDriveTrainSubsystem(){
        DriveTrain driveTrain = new DriveTrainBuilder().addLfSpeedControler(4).addRfSpeedControler(2).
          addLrSpeedControler(3).addRrSpeedControler(1).addDistanceSensor(3).
          setMaxOutput(MAX_DRIVE_TRAIN_POWER).addGyro().invertLeft().build();
        return driveTrain;
    }
    
    private HCSubsystem createGroupCommandsSubsystem(){
        return new GroupCommands();
    }
    
    private HCSubsystem createGamePadSubsystem(OI oi){
        return new GamePadSubsystem(oi);
    }
}