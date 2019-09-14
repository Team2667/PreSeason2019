package honeycrisp.subsystems;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.DoubleSolenoid;

public abstract class HCDoubleSolenoidBuilder<T extends HCDoubleSolenoid> {
    private int canId;
    private Map<String, DoubleSolenoid> solenoids;


    public HCDoubleSolenoidBuilder(int canId){
        this.canId = canId;
        solenoids = new HashMap<String, DoubleSolenoid>();
    }

    public HCDoubleSolenoidBuilder<T> addSolenoid(String key, int forwardChanel, int reverseChanel){
        DoubleSolenoid solenoid = createSolenoid(forwardChanel, reverseChanel);
        solenoids.put(key,solenoid);
        
        return this;
    }

    public T build(){
        T subsystem = newSubsystem();
        solenoids.keySet().forEach(k -> subsystem.addSolenoid(k, solenoids.get(k)));
        return subsystem;
    }

    protected DoubleSolenoid createSolenoid(int forwardChanel, int reverseChanel){
        return new DoubleSolenoid(canId, forwardChanel, reverseChanel);
    }

    protected abstract T newSubsystem();
}