// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.arm.ArmSubsystem;
import frc.robot.arm.commands.ArmControl;
import frc.robot.arm.commands.EncoderPrint;
import frc.robot.arm.commands.PIDControl;
import frc.robot.drive.DriveSubsystem;
import frc.robot.drive.commands.DriveSeparate;
import frc.robot.intake.IntakeSubsystem;
import frc.robot.intake.commands.IntakeControl;

public class RobotContainer {
  IntakeSubsystem intakeSubsystem = new IntakeSubsystem();
  DriveSubsystem driveSubsystem = new DriveSubsystem();
  XboxController driveController = new XboxController(0);
  XboxController operatorController = new XboxController(1);
  ArmSubsystem armSubsystem = new ArmSubsystem();
  ArmControl armControl = new ArmControl(armSubsystem, operatorController);
  EncoderPrint encoderPrint = new EncoderPrint(armSubsystem);
  
  SparkMaxxingI2cEncoder sparkmaxxer = new SparkMaxxingI2cEncoder(0, 0x06, 0, 0, 0);
  Robot robot;
  public RobotContainer(Robot robot) {
    driveSubsystem.setDefaultCommand(new DriveSeparate(driveSubsystem, driveController));
    this.robot = robot;
    robot.addPeriodic(()-> {System.out.println("SparkMaxxer Sez: " + sparkmaxxer.getRad());}, 0);
    // robot.addPeriodic(()-> {System.out.println("Encoder reads " + armSubsystem.getEncoder());}, 0);
    // robot.addPeriodic(()-> {System.out.println("Spud reads " + operatorController.getLeftY());}, 0);
    configureBindings();
  }

  private void configureBindings() {
    new Trigger(()-> Math.abs(operatorController.getLeftY()) >= 0.2).whileTrue(new ArmControl(armSubsystem, operatorController));
    new Trigger(()-> operatorController.getLeftBumper()).whileTrue(new IntakeControl(intakeSubsystem, -100));
    new Trigger(()-> operatorController.getRightBumper()).whileTrue(new IntakeControl(intakeSubsystem, 100));
    // System.out.println("Hello");
    new Trigger(()-> true).whileTrue(encoderPrint);
    // System.out.println("Farewell");
    
  }

  public Command getAutonomousCommand() {
    return Commands.print("No autonomous command configured");
  }
}

// new Trigger(()-> controller.getLeftTriggerAxis() > 0.2).whileTrue(new ArmControl(armSubsystem, operator));
// new Trigger(()-> controller.getRightTriggerAxis() > 0.2).whileTrue(new ArmControl(armSubsystem, operator));