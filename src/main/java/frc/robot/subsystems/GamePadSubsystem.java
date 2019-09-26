package frc.robot.subsystems;

import honeycrisp.cmdutils.OI;
import frc.robot.RobotMap;
import honeycrisp.cmdutils.CommandDirectory;
import honeycrisp.subsystems.HCSubsystem;

public class GamePadSubsystem extends HCSubsystem
{
    private OI oi;
    private static int AButton = 1;
    private static int BButton = 2;
    private static int XButton = 3;
    private static int YButton = 4;


    public GamePadSubsystem(OI oi){
        this.oi = oi;
    }

    @Override
    public void addCommands(CommandDirectory commandDirectory){
        commandDirectory.getJoyStickCommand(RobotMap.drive).addJoystick(oi.gamepad);
        oi.addButtonPress(commandDirectory.getButtonCommand(RobotMap.forwardForMillisStandalone), BButton);
        oi.addButtonPress(commandDirectory.getButtonCommand(RobotMap.forwardAndTurn), AButton);
        oi.addButtonPress(commandDirectory.getButtonCommand(RobotMap.grabPanel), XButton);
        oi.addButtonPress(commandDirectory.getButtonCommand(RobotMap.releasePanel), XButton);
    }

    @Override
    public void updateSmartDashboardValues(){
        
    }

}