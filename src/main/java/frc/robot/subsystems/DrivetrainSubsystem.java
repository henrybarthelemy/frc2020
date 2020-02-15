/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class DrivetrainSubsystem extends SubsystemBase {
  /**
   * Creates a new Drivetrain.
   */
  WPI_VictorSPX leftMaster, rightMaster, leftSlave, rightSlave;
  public DrivetrainSubsystem() {
    leftMaster = new WPI_VictorSPX(3);
    leftSlave = new WPI_VictorSPX(4);
    leftSlave.follow(leftMaster);
    leftMaster.setInverted(true);
    leftSlave.setInverted(true);


    rightMaster = new WPI_VictorSPX(1);
    rightSlave = new WPI_VictorSPX(2);
    rightSlave.follow(rightMaster);
    
  }

  public void tankDrive(double left, double right){
    left = left * left * Math.signum(left);
    right = right * right * Math.signum(right);
    leftMaster.set(left);
    rightMaster.set(right);
  }

  public void stop(){
    leftMaster.set(0);
    rightMaster.set(0);
  }

  @Override
  public void periodic() {
    
  }
}
