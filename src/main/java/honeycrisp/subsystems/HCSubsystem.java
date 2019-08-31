/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package honeycrisp.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import honeycrisp.CommandButtons;

/**
 * Add your docs here.
 */
public abstract class HCSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

 public abstract void addCommands(CommandButtons commandButtons);

 public abstract void updateSmartDashboardValues();

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
