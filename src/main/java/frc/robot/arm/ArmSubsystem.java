package frc.robot.arm;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;


import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSubsystem extends SubsystemBase{
    TalonSRX armMotor = new TalonSRX(10);

    public ArmSubsystem(){
        armMotor.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder);
    }

    public void armMove(double speed){
        armMotor.set(ControlMode.PercentOutput, speed);
    }

    public double getEncoder(){
        return armMotor.getSelectedSensorPosition();
    }





}
    