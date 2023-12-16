// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arm.ArmSubsystem;
import frc.robot.arm.commands.RunArmCommand;
import frc.robot.drive.DriveSubsystem;
import frc.robot.drive.commands.JoystickDriveCommand;
import frc.robot.roller.RollerSubsystem;
import frc.robot.roller.commands.IntakeCommand;

public class RobotContainer {
  DriveSubsystem driveSubsystem = new DriveSubsystem();
  ArmSubsystem armSubsystem = new ArmSubsystem();
  RollerSubsystem rollerSubsystem = new RollerSubsystem();
  XboxController driverController = new XboxController(0);
  XboxController operatorController = new XboxController(1);


  public RobotContainer() {

    configureBindings();

    driveSubsystem.setDefaultCommand(new JoystickDriveCommand(driveSubsystem, driverController));

  }

  private void configureBindings() {
    
    new Trigger(() -> (Math.abs(operatorController.getLeftY())>0.1)).whileTrue(new RunArmCommand(armSubsystem, () -> (operatorController.getLeftY()*0.5)));
    new Trigger(() -> (operatorController.getRightTriggerAxis()>0.5)).whileTrue(new IntakeCommand(rollerSubsystem, () -> (-0.5)));

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
