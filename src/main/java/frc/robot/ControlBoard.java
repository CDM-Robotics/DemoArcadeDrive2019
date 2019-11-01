package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Scheduler;
import frc.robot.commands.ArcadeDriveCmd;
import frc.robot.commands.DriveDistCmd;

public class ControlBoard {

    private static ControlBoard mControlBoard;

    public static ControlBoard getInstance() {
        if (mControlBoard == null) {
            mControlBoard = new ControlBoard();
        }
        return mControlBoard;
    }

    private ControlBoard(){
        Joystick stick0 = new Joystick(0);
        Joystick stick1 = new Joystick(1);
        JoystickButton topLeftButton = new JoystickButton(stick0, 5);
        Scheduler scheduler = Scheduler.getInstance();

        ArcadeDriveCmd arcadeDriveCmd = new ArcadeDriveCmd(stick0);
        DriveDistCmd driveDistCmd = new DriveDistCmd(.5, 3);

        scheduler.add(arcadeDriveCmd);
        topLeftButton.whenPressed(driveDistCmd);

    }

}