package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.RobotMap;
import honeycrisp.cmdutils.CommandDirectory;
import honeycrisp.subsystems.HCSubsystem;

public class GroupCommands extends HCSubsystem{

    @Override
    public void addCommands(CommandDirectory commandDirectory){
        Command cmd = createDriveThenTurn(commandDirectory);
        if (cmd != null){
            commandDirectory.addButtonCommand(RobotMap.forwardAndTurn, cmd);
        }
    }

    @Override
    public void updateSmartDashboardValues(){
        
    }


    private Command createDriveThenTurn(CommandDirectory commands){
        Command driveForward = commands.getgrpCmdCommand(RobotMap.forwardForMillis);
        Command turn = commands.getgrpCmdCommand(RobotMap.turnCounter45);
        if (driveForward != null && turn != null){
            CommandGroup returnCmd = new CommandGroup();
            returnCmd.addSequential(driveForward);
            returnCmd.addSequential(turn);
            return returnCmd;
        }
        return null;
    }
    
}