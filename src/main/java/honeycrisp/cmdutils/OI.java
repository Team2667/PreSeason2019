/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package honeycrisp.cmdutils;

import java.util.HashMap;

import edu.wpi.first.wpilibj.command.Command;
import honeycrisp.cmdutils.JoystickCommand;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  public GenericHID gamepad;

  public OI(GenericHID gamepad){
    this.gamepad = gamepad;
  }

  public void addButtonPress(Command command, int button){
    if (command != null ){
      JoystickButton jButton = new JoystickButton(gamepad,button);
      jButton.whenPressed(command);
    }
  }

  public void addButtonHeld(Command command, int button){
    if (command != null){
      JoystickButton jButton = new JoystickButton(gamepad, button);

      jButton.whileHeld(command);
    }
  }

  public void addButtonRelease(Command command, int button){
    if (command != null){
      JoystickButton jButton = new JoystickButton(gamepad, button);
      jButton.whenReleased(command);
    }
  }

  public void addJoystickCommand(JoystickCommand command){
    if (command != null){
      command.addJoystick(gamepad);
    }
  }
}
