// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

import com.revrobotics.spark.SparkLowLevel.MotorType;



public class PhotoMotor extends SubsystemBase {
  /** Create a motor */
  SparkMax motor = new SparkMax(0,SparkLowLevel.MotorType.kBrushless);
  /** Use photo electric sensor 1 */
  AnalogInput photoSensor = new AnalogInput(0);
  public boolean getPhotoElectricSensor() {
    /** detects if there is an object */
    
    return photoSensor.getVoltage() < 2;
  }
  public PhotoMotor() {}

  @Override
  public void periodic() {
    /** make it spin at 25% if an object is detected */
    if(getPhotoElectricSensor()){
      motor.set(0.25);
    }else{
      motor.set(0);
    }
  }
}
