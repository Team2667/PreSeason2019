package frc.robot.subsystems;

import org.junit.Before;
import org.junit.Test;

import edu.wpi.first.wpilibj.DoubleSolenoid;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class PanelGrabberTest {
    private DoubleSolenoid panelSol;
    private PanelGrabber panelGrabber;

    @Before
    public void setUp(){
        MockPanelGrabberBuilder builder = new MockPanelGrabberBuilder();
        builder.addSolenoid("hatch", 1, 2);
        panelGrabber = builder.build();
        panelSol = builder.getMockedSolinoid();
    }


    @Test
    public void releasePanelShouldShouldRetractRam(){
        panelGrabber.releasePanel();
        verify(panelSol,times(1)).set(DoubleSolenoid.Value.kReverse);
    }
}