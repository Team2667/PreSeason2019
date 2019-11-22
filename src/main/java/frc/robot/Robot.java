/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import java.util.ArrayList;
import java.util.List;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import frc.robot.subsystems.ArmExtenderBuilder;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.DriveTrainBuilder;
import frc.robot.subsystems.GamePadSubsystem;
import frc.robot.subsystems.GroupCommands;
import frc.robot.subsystems.PanelGrabberBuilder;
import honeycrisp.cmdutils.CommandDirectory;
import honeycrisp.cmdutils.OI;
import honeycrisp.subsystems.HCSubsystem;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  public static OI m_oi;
  private List<HCSubsystem> subsystems;
  private CommandDirectory commandDirectory = new CommandDirectory();

  // When creating the drive train, set the maximum output to this value.
  // The max output can be set directory on the DriveTrain from a drive train 
  // command. For example, the initliize method can set the max ouput in the initialize
  // method. Any drive train that does this, should set it back in the end()/interrupted() methods.
  private static double MAX_DRIVE_TRAIN_POWER = 0;

  Command m_autonomousCommand;
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    m_oi = new OI(new XboxController(0));
    subsystems = new ArrayList<HCSubsystem>();


    // chooser.addOption("My Auto", new MyAutoCommand());

    subsystems.add(createDriveTrainSubsystem());
    subsystems.add(createPanelGrabberSubsystem());
    subsystems.add(createArmExtender());
    subsystems.add(createGroupCommandsSubsystem());
    subsystems.add(createGamePadSubsystem(m_oi));
    subsystems.forEach(sub -> sub.addCommands(commandDirectory));
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    subsystems.forEach(sub -> sub.updateSmartDashboardValues());
  }

  /**
   * This function is called once each time the robot enters Disabled mode.
   * You can use it to reset any subsystem information you want to clear when
   * the robot is disabled.
   */
  @Override
  public void disabledInit() {
  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString code to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional commands to the
   * chooser code above (like the commented example) or additional comparisons
   * to the switch structure below with additional strings & commands.
   */
  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_chooser.getSelected();

    /*
     * String autoSelected = SmartDashboard.getString("Auto Selector",
     * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
     * = new MyAutoCommand(); break; case "Default Auto": default:
     * autonomousCommand = new ExampleCommand(); break; }
     */

    // schedule the autonomous command (example)
    if (m_autonomousCommand != null) {
      m_autonomousCommand.start();
    }
  }

  /**
   * This function is called periodically during autonomous.
   */
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
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Scheduler.getInstance().run();
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }

  private HCSubsystem createDriveTrainSubsystem(){
    DriveTrain driveTrain = new DriveTrainBuilder().addLfSpeedControler(4).addRfSpeedControler(2).
      addLrSpeedControler(3).addRrSpeedControler(1).addDistanceSensor(3).
      setMaxOutput(MAX_DRIVE_TRAIN_POWER).addGyro().invertLeft().build();
    return driveTrain;
  }

  public HCSubsystem createPanelGrabberSubsystem(){
    PanelGrabberBuilder builder = new PanelGrabberBuilder(8);
    builder.addSolenoid("hatch", 0, 1);
    return builder.build();
  }

  private HCSubsystem createGroupCommandsSubsystem(){
    return new GroupCommands();
  }

  private HCSubsystem createGamePadSubsystem(OI oi){
    return new GamePadSubsystem(oi);
  }

  private HCSubsystem createArmExtender(){
    ArmExtenderBuilder builder = new ArmExtenderBuilder();
    builder.setCanId(6);
    return builder.build();
  }
}
