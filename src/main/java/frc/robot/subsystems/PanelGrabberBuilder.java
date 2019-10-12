package frc.robot.subsystems;

import honeycrisp.subsystems.HCDoubleSolenoidBuilder;

public class PanelGrabberBuilder extends HCDoubleSolenoidBuilder{
    public PanelGrabberBuilder(int canId){
        super(canId);
    }

    protected PanelGrabber newSubsystem(){
        return new PanelGrabber();
    }
}