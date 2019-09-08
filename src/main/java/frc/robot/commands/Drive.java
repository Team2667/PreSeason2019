/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID;
import honeycrisp.cmdutils.JoystickCommand;
import honeycrisp.subsystems.HCDriveTrain;

public class Drive extends JoystickCommand{
  private HCDriveTrain driveTrain;
  private GenericHID joy;
  private double prevMaxOutput;

  // Sets the maximum output for the drive train when driving the robot with a joystick.
  private final double MAX_OUTPUT = .5;

  public Drive(HCDriveTrain driveTrain) {
    requires(driveTrain);
    this.driveTrain = driveTrain;
    this.requires(driveTrain);
  }

  @Override
  public void addJoystick(GenericHID joy){
    this.joy = joy;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
      prevMaxOutput = driveTrain.getMaxOutput();
      driveTrain.setMaxOutput(MAX_OUTPUT);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    driveTrain.arcadeDrive(joy);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    driveTrain.stop();
    driveTrain.setMaxOutput(prevMaxOutput);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    end();
  }
}
