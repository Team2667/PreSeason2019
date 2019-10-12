package honeycrisp.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public abstract class HCSimpleTalonBuilder<T extends HCSimpleTalon> {
    private WPI_TalonSRX talon;

    public HCSimpleTalonBuilder<T> setCanId(int canId){
        talon = new WPI_TalonSRX(canId);
        return this;
    }

    public abstract T newSimpleTalon(WPI_TalonSRX talon);

    public T build(){
        return newSimpleTalon(talon);
    }
}