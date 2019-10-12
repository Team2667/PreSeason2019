package honeycrisp.subsystems;

import java.util.HashMap;
import java.util.Map;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public abstract class HCDoubleSolenoid extends HCSubsystem{
    private Map<String,DoubleSolenoid> solenoids;

    public HCDoubleSolenoid(){
        solenoids = new HashMap<String,DoubleSolenoid>();
    }

    void addSolenoid(String key, DoubleSolenoid solenoid){
        solenoids.put(key,solenoid);
    }

    public void extendRam(String ramName){
        DoubleSolenoid sol = solenoids.get(ramName);
        if (sol == null){
            // write a message to console
        } else {
            System.out.println("extending ram");
            sol.set(Value.kForward);
            // call a method on sol to extend the ram
        }
    }

    public void retractRam(String ramName){
        DoubleSolenoid sol = solenoids.get(ramName);
        if (sol == null){
            // write a message to console
        } else {
            sol.set(Value.kReverse);
            // call a method on sol to extend the ram
        } // Implement. 
    }
}