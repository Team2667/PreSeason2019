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
    private static int leftTrigger = 5;
    private static int rightTrigger = 6;
    private static int backbutton = 7;
    private static int startbutton = 8;

    public GamePadSubsystem(OI oi){
        this.oi = oi;
    }

    @Override
    public void addCommands(CommandDirectory commandDirectory){
        commandDirectory.getJoyStickCommand(RobotMap.drive).addJoystick(oi.gamepad);
        oi.addButtonPress(commandDirectory.getButtonCommand(RobotMap.grabPanel), XButton);
        oi.addButtonPress(commandDirectory.getButtonCommand(RobotMap.releasePanel), YButton);
        oi.addButtonHeld(commandDirectory.getButtonCommand(RobotMap.extendArm),  leftTrigger);
        oi.addButtonHeld(commandDirectory.getButtonCommand(RobotMap.retractArm), rightTrigger);
    }

    @Override
    public void updateSmartDashboardValues(){
        
    }

}