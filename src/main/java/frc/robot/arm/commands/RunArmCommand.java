package frc.robot.arm.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.arm.ArmSubsystem;

public class RunArmCommand extends CommandBase{

    ArmSubsystem armSubsystem;
    Supplier<Double> speed;

    public RunArmCommand(ArmSubsystem armSubsystem, Supplier<Double> speed){
        addRequirements(armSubsystem);
        this.armSubsystem = armSubsystem;
        this.speed = speed;
    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
        armSubsystem.setArmSpeed(speed.get());
        System.out.println(speed.get());
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
