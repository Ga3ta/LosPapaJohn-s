/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.OI;
import frc.robot.RobotMap;

/**
 * Add your docs here.
 */
public class PapaDrive extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public static TalonSRX left;
  public static TalonSRX right;
  public static Joystick joy;
  public static int dir;
  public static double TOLERANCE;

  public PapaDrive(){
    left = RobotMap.LEFT_D;
    right = RobotMap.RIGHT_D;
    joy = OI.JOY0;
    dir = 1;
    TOLERANCE = 0.2;
    left.setInverted(true);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void Main_Drive(){
    double POWER = joy.getRawAxis(3) - joy.getRawAxis(2);
    double steer = joy.getRawAxis(0) * 0.6;

    if(Math.abs(POWER)>TOLERANCE){
      left.set(ControlMode.PercentOutput, dir*StickMap(TOLERANCE, POWER) + steer);
      right.set(ControlMode.PercentOutput, dir*StickMap(TOLERANCE, POWER) - steer);
    }
  }

  public double StickMap(double tol, double in){
    double out = ((Math.abs(in)-tol)/(1-tol))*(Math.abs(in)/in);
    return out;
  }
}
