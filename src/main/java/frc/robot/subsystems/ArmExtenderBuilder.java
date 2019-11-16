package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import honeycrisp.subsystems.HCSimpleTalonBuilder;

public class ArmExtenderBuilder extends HCSimpleTalonBuilder<ArmExtender>{

    @Override()
    public ArmExtender newSimpleTalon(WPI_TalonSRX talon) {
        return new ArmExtender(talon);
    }
}