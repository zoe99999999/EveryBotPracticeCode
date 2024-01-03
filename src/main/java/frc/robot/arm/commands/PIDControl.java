package frc.robot.arm.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arm.ArmSubsystem;

public class PIDControl extends CommandBase{
    PIDController pid = new PIDController(0, 0, 0);
    ArmSubsystem armSubsystem;
    double setpoint;
    public PIDControl(ArmSubsystem armSubsystem, double setpoint){
        this.armSubsystem = armSubsystem;
        this.setpoint = setpoint;
        addRequirements(armSubsystem);
    }

    @Override
    public void initialize() {
        
    }

    @Override
    public void execute() {
        double spad = pid.calculate(armSubsystem.getEncoder(), setpoint);
        armSubsystem.armMove(spad);
    }

    @Override
    public void end(boolean interrupted) {

    }

    @Override
    public boolean isFinished() {

        return false;
    }
    
}
