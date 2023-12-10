package frc.robot.arm.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arm.ArmSubsystem;

public class RunArmCommand extends CommandBase{

    ArmSubsystem armSubsystem;
    XboxController driverController;
    Double speed;

    public RunArmCommand(ArmSubsystem armSubsystem, XboxController driverController, double speed){
        addRequirements(armSubsystem);
        this.armSubsystem = armSubsystem;
        this.driverController = driverController;
        this.speed = speed;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        armSubsystem.setArmSpeed(speed);
        armSubsystem.printEncoaderValue();
    }

    @Override
    public void end(boolean interrupted) {
        armSubsystem.setArmSpeed(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
    
}
