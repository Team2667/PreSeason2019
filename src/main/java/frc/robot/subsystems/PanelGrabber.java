package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.GrabPanel;
import frc.robot.commands.ReleasePanel;
import honeycrisp.cmdutils.CommandDirectory;
import honeycrisp.subsystems.HCDoubleSolenoid;

public class PanelGrabber extends HCDoubleSolenoid{

    public void releasePanel(){
        this.retractRam("hatch");
    }
    
    public void grabpannel(){
        this.extendRam("hatch");
     }
    // ToDo: Add additional methods


    public void addCommands(CommandDirectory commandDirectory){
        commandDirectory.addButtonCommand(RobotMap.grabPanel, new GrabPanel(this));
        commandDirectory.addButtonCommand(RobotMap.grabPanel, new ReleasePanel(this));
    }
 
    public void updateSmartDashboardValues(){

    }
}