package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import honeycrisp.subsystems.HCDoubleSolenoidBuilder;
import static org.mockito.Mockito.*;

public class MockPanelGrabberBuilder extends HCDoubleSolenoidBuilder<PanelGrabber>{
    private DoubleSolenoid mockedSolenoid;
    public MockPanelGrabberBuilder(){
        super(42);
    }

    protected PanelGrabber newSubsystem(){
        return new PanelGrabber();
    }

    protected DoubleSolenoid createSolenoid(int forwardChanel, int reverseChanel){
        this.mockedSolenoid = mock(DoubleSolenoid.class);
        return mockedSolenoid;
    }

    public DoubleSolenoid getMockedSolinoid(){
        return mockedSolenoid;
    }
}