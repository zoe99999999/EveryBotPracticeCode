package frc.robot.arm.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arm.ArmSubsystem;

public class EncoderPrint extends CommandBase{
    ArmSubsystem armSubsystem;
    public EncoderPrint(ArmSubsystem armSubsystem){
        this.armSubsystem = armSubsystem;
    }
    @Override
    public void execute(){
        System.out.println("Encoder reads " + armSubsystem.getEncoder());
    }
}
