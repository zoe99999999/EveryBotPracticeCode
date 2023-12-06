package frc.robot.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{
    TalonSRX driveMoterL1 = new TalonSRX(6);
    TalonSRX driveMoterL2 = new TalonSRX(5);
    TalonSRX driveMoterR1 = new TalonSRX(4);
    TalonSRX driveMoterR2 = new TalonSRX(3);

    public DriveSubsystem (){}

    private void setLeftMotor(double speed){
        driveMoterL1.set(ControlMode.PercentOutput, speed);
        driveMoterL2.set(ControlMode.PercentOutput, speed);
    }
    private void setRightMotor(double speed){
        driveMoterR1.set(ControlMode.PercentOutput, speed);
        driveMoterR2.set(ControlMode.PercentOutput, speed);
    }

    public void drive(double speed, double steerWeight){
        double leftSpeed = speed * (1 - steerWeight);
        double rightSpeed = speed * (1 + steerWeight);
        if (leftSpeed>1){
            leftSpeed = 1;
        }
        if (leftSpeed<-1){
            leftSpeed = -1;
        }
        if (rightSpeed>1){
            rightSpeed = 1;
        }
        if (rightSpeed<-1){
            rightSpeed = -1;
        }
        setRightMotor(rightSpeed);
        setLeftMotor(leftSpeed);

    }



    
}
