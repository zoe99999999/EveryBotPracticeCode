package frc.robot.arm.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arm.ArmSubsystem;

public class ArmControl extends CommandBase{
    ArmSubsystem armSubsystem;
    XboxController operatorController;
    public ArmControl(ArmSubsystem armSubsystem, XboxController operatorController){
        this.armSubsystem = armSubsystem;
        this.operatorController = operatorController;
        addRequirements(armSubsystem);
    }
    @Override
    public void initialize(){
        
    }


    @Override
    public void execute(){
        double spud = operatorController.getLeftY()*0.35;
        double encoderValue = armSubsystem.getEncoder();
        double speed = spud;
        if (encoderValue >= -500){
            speed = Math.min(spud, 0);
        }
        if (encoderValue <= -2000){
            speed = Math.max(spud, 0);
        }
        // if (encoderValue >= -450){
        //     armSubsystem.armMove(Math.min(spud, spud*0.5));
        // }
        // if (encoderValue <= -1200){
        //     armSubsystem.armMove(Math.max(spud, spud*0.5));
        // }
        //500, -2200
        // if(spud > 0.2 && armSubsystem.getEncoder() >= -1200){
        //     armSubsystem.armMove(spud);
        // }
        // else if(spud > 0.2 && armSubsystem.getEncoder() < -1200){
        //     armSubsystem.armMove(spud*0.5);
        // }
        // else if(spud < -0.2 && armSubsystem.getEncoder() <= -450  && armSubsystem.getEncoder() > -2200){
        //     armSubsystem.armMove(spud);
        // }
        // else if (spud < -0.2 && armSubsystem.getEncoder() > -450 && armSubsystem.getEncoder() < 200){
        //     armSubsystem.armMove(spud*0.5);
        // }
        armSubsystem.armMove(speed);

        //&& armSubsystem.getEncoder() 
        // System.out.println("Spud reads " + spud);
        System.out.println("Encoder: " + encoderValue);
        System.out.println("Speed: " + spud);
    }


    @Override
    public void end(boolean interrupted){
        armSubsystem.armMove(0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
