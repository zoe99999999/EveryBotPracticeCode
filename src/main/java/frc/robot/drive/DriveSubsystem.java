package frc.robot.drive;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DriveSubsystem extends SubsystemBase{
    TalonSRX driveMotorL1 = new TalonSRX(5);
    TalonSRX driveMotorL2 = new TalonSRX(6);
    TalonSRX driveMotorR1 = new TalonSRX(3);
    TalonSRX driveMotorR2 = new TalonSRX(4);

    public DriveSubsystem (){
        driveMotorL1.setInverted(true);
        driveMotorL2.setInverted(true);
    }
    public void allDrive(double l1Speed, double l2Speed, double r1Speed, double r2Speed){
        driveMotorL1.set(ControlMode.PercentOutput, l1Speed);
        driveMotorL2.set(ControlMode.PercentOutput, l2Speed);
        driveMotorR1.set(ControlMode.PercentOutput, r1Speed);
        driveMotorR2.set(ControlMode.PercentOutput, r2Speed);
    }

    /*public void moveSpin(double move, double spin){
        allDrive(move+spin, move+spin, move-spin, move-spin);
    }*/

    /*public void moveSeparate(double leftMove, double rightMove){
        allDrive(leftMove, leftMove, rightMove, rightMove);
    }*/

    public void vroom(double vspeed){
        allDrive(vspeed, vspeed, vspeed, vspeed);
    }

    public void whoosh(double rspeed){
        allDrive(-rspeed, -rspeed, rspeed, rspeed);
    }

    // public void rotateDrive(double forward, double rotate){
    //     if(rotate > 0){
    //         allDrive(forward-Math.abs(rotate), forward-Math.abs(rotate), forward, forward);
    //     }
    //     else if(rotate < 0){
    //         allDrive(forward, forward, forward-Math.abs(rotate), forward-Math.abs(rotate));
    //     }
    //     else {
    //         allDrive(forward, forward, forward, forward);
    //     }
    // }
}
