package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.subsystems.DriveSys;

public class ArcadeDriveCmd extends Command{

    private Joystick mStick;
    private DriveSys mDriveSys;
    
    public ArcadeDriveCmd(Joystick stick){
        mStick = stick;
        mDriveSys = DriveSys.getInstance();
        requires(mDriveSys);
    }
     
    public void initialize(){

    }

    public void execute(){
        double y = mStick.getY();
        double x = mStick.getX();
        y = -y;
        x = x * .8;
        mDriveSys.arcadeDrive(y, x);
    }

    public boolean isFinished(){
        return false;
    }
}