package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveSys extends Subsystem {

    private static DriveSys mDriveSys;

    private DifferentialDrive mRobot_Differential_Drive;
    private WPI_TalonSRX mLeftMaster;
    private WPI_TalonSRX mLeftSlave0;
    private WPI_TalonSRX mRightMaster;
    private WPI_TalonSRX mRightSlave0;

    public static DriveSys getInstance() {
        if (mDriveSys == null) {
            mDriveSys = new DriveSys();
        }
        return mDriveSys;
    }

    private DriveSys() {

        mLeftMaster = new WPI_TalonSRX(30);
        mLeftSlave0 = new WPI_TalonSRX(1);
        mRightMaster = new WPI_TalonSRX(14);
        mRightSlave0 = new WPI_TalonSRX(15);

        mLeftSlave0.follow(mLeftMaster);
        mRightSlave0.follow(mRightMaster);

        mRobot_Differential_Drive = new DifferentialDrive(mLeftMaster, mRightMaster);
    }

    public void arcadeDrive(double magnitude, double yaw){
        mRobot_Differential_Drive.arcadeDrive(magnitude, yaw);
    }

    public int getCurrentPosition(){
        return mLeftMaster.getSensorCollection().getQuadraturePosition();
    }

    public void initDefaultCommand() {

    }

}