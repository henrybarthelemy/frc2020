/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;

import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the DifferentialDrive class.
 * Runs the motors with tank steering and an Xbox controller.
 */
public class Robot extends TimedRobot {
  private final WPI_VictorSPX rightFrontMotor = new WPI_VictorSPX(1);
  private final VictorSPX rightRearMotor = new VictorSPX(2);
  private final WPI_VictorSPX leftFrontMotor = new WPI_VictorSPX(3);
  private final VictorSPX leftRearMotor = new VictorSPX(4);
  boolean started = false;

  DifferentialDrive robotDrive = null;
  private final XboxController m_driverController = new XboxController(0);

  @Override
  public void teleopPeriodic() {
    if(started == false){
      rightFrontMotor.addChild(rightRearMotor);
      leftFrontMotor.addChild(leftRearMotor);
      robotDrive = new DifferentialDrive(rightFrontMotor, leftFrontMotor);
    }
    // Drive with tank drive.
    // That means that the Y axis of the left stick moves the left side
    // of the robot forward and backward, and the Y axis of the right stick
    // moves the right side of the robot forward and backward.
    robotDrive.tankDrive(m_driverController.getY(Hand.kLeft),
        m_driverController.getY(Hand.kRight));
  }
}
