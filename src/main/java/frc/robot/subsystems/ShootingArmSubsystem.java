/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShootingArmSubsystem extends SubsystemBase {
  /**
   * Creates a new ShootingArm.
   */
  WPI_VictorSPX intakeLeftMaster, intakeRightSlave, shooterLeftMaster, shooterRightSlave;
  public ShootingArmSubsystem() {
    intakeLeftMaster = new WPI_VictorSPX(3);
    intakeRightSlave = new WPI_VictorSPX(4);
    intakeRightSlave.follow(intakeLeftMaster);

    shooterLeftMaster = new WPI_VictorSPX(1);
    shooterRightSlave = new WPI_VictorSPX(2);
    shooterLeftMaster.follow(shooterRightSlave);
    
  }

  public void setShooterSpeed(double speed){
    speed = speed * speed * Math.signum(speed);
    shooterLeftMaster.set(speed);
  }

  public void setIntakeSpeed(double speed){
    speed = speed * speed * Math.signum(speed);
    intakeLeftMaster.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void stop() {
    shooterLeftMaster.set(0);
    intakeLeftMaster.set(0);
  }
}
