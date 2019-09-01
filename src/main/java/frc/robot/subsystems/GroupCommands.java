package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import honeycrisp.cmdutils.CommandDirectory;
import honeycrisp.cmdutils.CommandGroupUtils;
import honeycrisp.subsystems.HCSubsystem;

public class GroupCommands extends HCSubsystem{

    @Override
    public void addCommands(CommandDirectory commandDirectory){
        commandDirectory.addButtonCommand(RobotMap.forwardAndTurn, createDriveThenTurn(commandDirectory));
    }

    @Override
    public void updateSmartDashboardValues(){
        
    }

    private Command createDriveThenTurn(CommandDirectory commands){
        return CommandGroupUtils.createSequencialCommandGroup(
                commands.getgrpCmdCommand(RobotMap.forwardForMillis),
                commands.getgrpCmdCommand(RobotMap.turnCounter45));
    }
}