package frc.robot.intake.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.intake.IntakeSubsystem;

public class IntakeControl extends CommandBase{
    IntakeSubsystem intakeSubsystem;
    double speedOfIntake;
    public IntakeControl(IntakeSubsystem intakeSubsystem, double speedOfIntake){
        this.intakeSubsystem = intakeSubsystem;
        this.speedOfIntake = speedOfIntake;
        addRequirements(intakeSubsystem);
    }
    @Override
    public void initialize(){
        
    }

    @Override
    public void execute(){
        intakeSubsystem.intakeRun(speedOfIntake);
    }


    @Override
    public void end(boolean interrupted){
       intakeSubsystem.intakeRun(0.0);
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}