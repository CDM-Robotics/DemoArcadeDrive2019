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
  private WPI_TalonSRX mLeftMaster;
  private WPI_TalonSRX mLeftSlave0;
  private WPI_TalonSRX mRightMaster;
  private WPI_TalonSRX mRightSlave0;
  private Joystick mLeftStick;
  private Joystick mRightStick;

  @Override
  public void robotInit() {
    mLeftMaster = new WPI_TalonSRX(30);
    mLeftSlave0 = new WPI_TalonSRX(1);
    mRightMaster = new WPI_TalonSRX(14);
    mRightSlave0 = new WPI_TalonSRX(15);

    mLeftSlave0.follow(mLeftMaster);
    mRightSlave0.follow(mRightMaster);

    mLeftStick = new Joystick(0);
    mRightStick = new Joystick(1);

    m_myRobot = new DifferentialDrive(mLeftMaster, mRightMaster);
  }


  public void teleopPeriodic() {
    m_myRobot.arcadeDrive(mLeftStick.getY(), mLeftStick.getX());
  }
}
