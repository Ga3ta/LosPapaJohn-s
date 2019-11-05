/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  //Ints
  public static final int LD = 0;
  public static final int RD = 1;
  
  //TalonSRX
  public static TalonSRX LEFT_D;
  public static TalonSRX RIGHT_D;

  public static void init(){
    LEFT_D = new TalonSRX(LD);
    RIGHT_D = new TalonSRX(RD);
  }
}
