package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.commands.ExtendArm;
import frc.robot.commands.RetractArm;
import honeycrisp.cmdutils.CommandDirectory;
import honeycrisp.subsystems.HCSimpleTalon;

public class ArmExtender extends HCSimpleTalon {
    
  ArmExtender(WPI_TalonSRX talon){
      super(talon);
  }
  
  @Override
  public void addCommands(CommandDirectory commandDirectory) {
    
   
    commandDirectory.addButtonCommand(RobotMap.extendArm, new ExtendArm(this));
    commandDirectory.addButtonCommand(RobotMap.retractArm, new RetractArm(this));
  }


  @Override
  public void updateSmartDashboardValues() {
      // If we have anything we want to show on the smart dashboard we can do so here.
      // One posibility is to show the state of the arm.
  }

  @Override
  public void setDefaultCommand(Command comand){
     // This subsystem shouldn't need a default command so leave empty   
  }
}