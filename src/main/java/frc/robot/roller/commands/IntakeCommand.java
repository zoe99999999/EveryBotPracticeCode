package frc.robot.roller.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.roller.RollerSubsystem;

public class IntakeCommand extends CommandBase{
    Supplier<Double> speed;
    RollerSubsystem rollerSubsystem;
    public IntakeCommand(RollerSubsystem rollerSubsystem, Supplier<Double> speed){
        addRequirements(rollerSubsystem);
        this.speed = speed;
        this.rollerSubsystem = rollerSubsystem;
    }

    @Override
    public void initialize() {
        rollerSubsystem.runRoller(speed.get());
    }

    @Override
    public void execute() {
    }

    @Override
    public void end(boolean interrupted) {
        rollerSubsystem.runRoller(0);
    }

    @Override
    public boolean isFinished() {
        return false;
    }
    
}
