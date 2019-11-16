package honeycrisp.subsystems;

import java.util.Set;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public abstract class HCSimpleTalon extends HCSubsystem{
    private WPI_TalonSRX talon;

    public HCSimpleTalon(WPI_TalonSRX talon){
        this.talon = talon;
    }

    public void move(double power){
        talon.set(power);
        //The power is a double (real) number between -1.0 - 1.0.
        // It represents the precentage of power to apply to a motor through the talon.
        // 1 is 100% .5 is 50% etctera

    }

    public void stop(){
            talon.set(0);

    }
}