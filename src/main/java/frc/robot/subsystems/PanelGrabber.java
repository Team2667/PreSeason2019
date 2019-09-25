package frc.robot.subsystems;

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
        // ToDo: add PanelGrabber commands here.
        //
    }
 
    public void updateSmartDashboardValues(){

    }
}