package frc.robot.drive.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.drive.DriveSubsystem;

public class DriveSeparate extends CommandBase{
    DriveSubsystem driveSubsystem;
    XboxController driveController;
    public DriveSeparate(DriveSubsystem driveSubsystem, XboxController driveController){
        this.driveSubsystem = driveSubsystem;
        this.driveController = driveController;
        addRequirements(driveSubsystem);
    }
    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
        double sped = driveController.getLeftY()*0.5;
      if(Math.abs(driveController.getLeftY()) <= 0.4){
        sped = 0.0;
      }
      double spod = driveController.getRightX()*0.5;
      if(Math.abs(driveController.getRightX()) <= 0.4){
        spod = 0.0;
      }
      if(sped != 0.0 && spod == 0.0){
        driveSubsystem.vroom(sped);
      }
      else if(sped == 0.0 && spod != 0.0){
        driveSubsystem.whoosh(spod);
      }
      else{
        driveSubsystem.vroom(0.0);
      }
    }


    @Override
    public void end(boolean interrupted){
        
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    
}