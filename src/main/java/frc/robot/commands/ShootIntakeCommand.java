/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ShootingArmSubsystem;

public class ShootIntakeCommand extends CommandBase {
  /**
   * Creates a new ShootIntakeCommand.
   */
  ShootingArmSubsystem arm;
  XboxController controller;
  double leftTrigger, rightTrigger, rightY, shooterSpeed = 0, intakeSpeed = 0;
  public ShootIntakeCommand(ShootingArmSubsystem subsystem, XboxController controller) {
    this.arm = subsystem;
    this.controller = controller;
    addRequirements(subsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    updateValues();
    arm.setShooterSpeed(shooterSpeed);
    arm.setShooterSpeed(intakeSpeed);
  }
  private void updateValues(){
    leftTrigger = controller.getTriggerAxis(Hand.kLeft);
    rightTrigger = controller.getTriggerAxis(Hand.kRight);
    rightY = controller.getY(Hand.kRight);
    
    shooterSpeed = leftTrigger - rightTrigger;
    intakeSpeed = rightY;

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.stop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
