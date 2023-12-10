// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arm.ArmSubsystem;
import frc.robot.arm.commands.RunArmCommand;
import frc.robot.drive.DriveSubsystem;
import frc.robot.drive.commands.JoystickDriveCommand;

public class RobotContainer {
  DriveSubsystem driveSubsystem = new DriveSubsystem();
  ArmSubsystem armSubsystem = new ArmSubsystem();
  XboxController driverController = new XboxController(0);
  XboxController operatorController = new XboxController(1);


  public RobotContainer() {

    configureBindings();

    driveSubsystem.setDefaultCommand(new JoystickDriveCommand(driveSubsystem, driverController));

  }

  private void configureBindings() {
    
    new Trigger(() -> driverController.getLeftBumper()).onTrue(new RunArmCommand(armSubsystem, driverController, 0.75));
    new Trigger(() -> (driverController.getLeftTriggerAxis() > 0.5)).onTrue(new RunArmCommand(armSubsystem, driverController, -0.5));

  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}
