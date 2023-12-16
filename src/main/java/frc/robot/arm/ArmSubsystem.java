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

    // public void setArmPostionDown(boolean Position){
    //     armMotor.set(ControlMode.Position, );
    // }
    public void setArmSpeed(double speed){
        armMotor.set(ControlMode.PercentOutput, speed);
    }
    
    public void printEncoaderValue(){
        System.out.println(armMotor.getSelectedSensorPosition());
    }

    // @Override
    // public void periodic() {
    //     printEncoaderValue();
    // }
    
}
