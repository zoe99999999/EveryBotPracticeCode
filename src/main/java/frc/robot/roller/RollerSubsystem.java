package frc.robot.roller;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class RollerSubsystem extends SubsystemBase {
    TalonSRX roller = new TalonSRX(1);
    public RollerSubsystem(){}

    public void runRoller(double speed){
        roller.set(ControlMode.PercentOutput, speed);
    }
}
