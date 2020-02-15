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
import frc.robot.subsystems.DrivetrainSubsystem;

public class TankDriveCommand extends CommandBase {
   final DrivetrainSubsystem drivetrain;
   double left;
   double right;
   XboxController driver;
  /**
   * Creates a new TankDriveCommand.  public ExampleCommand(ExampleSubsystem subsystem) {
    m_subsystem = subsystem;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(subsystem);
  }

   */
 

  public TankDriveCommand(DrivetrainSubsystem drivetrainSubsystem, XboxController driver) {
    System.out.print("Running");
    this.drivetrain = drivetrainSubsystem;
    this.driver = driver;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }


// Called when the command is initially scheduled.
  @Override
  public void initialize() {
   
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.tankDrive(driver.getY(Hand.kLeft), driver.getY(Hand.kRight));
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(final boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
