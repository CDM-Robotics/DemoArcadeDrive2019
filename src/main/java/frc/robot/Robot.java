/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private DifferentialDrive m_myRobot;
  private Joystick m_leftStick;
  private Joystick m_rightStick;

  @Override
  public void robotInit() {
    WPI_TalonSRX mLeft_Master = new WPI_TalonSRX(30);
    WPI_TalonSRX mLeftSlave = new WPI_TalonSRX(1);
    WPI_TalonSRX mRightMaster = new WPI_TalonSRX(14);
    WPI_TalonSRX mRightSlave = new WPI_TalonSRX(15);
    
    mLeftSlave.follow(mLeft_Master);
    mRightSlave.follow(mRightMaster);
    
    m_myRobot = new DifferentialDrive(mLeft_Master, mRightMaster);
    m_leftStick = new Joystick(0);
    m_rightStick = new Joystick(1);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.arcadeDrive(m_leftStick.getY(), m_leftStick.getX());
  }
}