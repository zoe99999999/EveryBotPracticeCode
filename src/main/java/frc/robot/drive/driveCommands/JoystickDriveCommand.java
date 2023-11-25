package frc.robot.drive.driveCommands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.drive.DriveSubsystem;

public class JoystickDriveCommand extends CommandBase {

    XboxController driverController;
    DriveSubsystem driveSubsystem;

    public JoystickDriveCommand(DriveSubsystem driveSubsystem, XboxController driverController){

        this.driveSubsystem = driveSubsystem;
        this.driverController = driverController;
        
    }

    @Override
    public void initialize() {
        // TODO Auto-generated method stub
        super.initialize();
    }

    @Override
    public void execute() {
        double steerWeight; //TODO: set steerweight to drivercontrollerleft joystick x value
        double speed; //TODO: set steerweight to drivercontrollerleft joystick -y value
    }
    
    @Override
    public void end(boolean interrupted) {}

    @Override
    public boolean isFinished() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
