/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.PWMTalonSRX;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DriveTrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.utils.Controller;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
	// The robot's subsystems and commands are defined here...
	private static Controller m_controller = new Controller(Constants.ControllerConstants.controllerPort);
	private static DriveTrainSubsystem m_driveTrain;
	private static IntakeSubsystem m_intake;

	/**
	 * The container for the robot. Contains subsystems, OI devices, and commands.
	 */
	public RobotContainer() {
		// Configure the button bindings
		configureButtonBindings();
		m_driveTrain = new DriveTrainSubsystem(new PWMTalonSRX(Constants.DriveTrainConstants.fRight),
				new PWMTalonSRX(Constants.DriveTrainConstants.bRight),
				new PWMTalonSRX(Constants.DriveTrainConstants.fLeft),
				new PWMTalonSRX(Constants.DriveTrainConstants.bLeft));
		m_intake = new IntakeSubsystem(new PWMTalonSRX(Constants.IntakeConstants.belt),
				new PWMTalonSRX(Constants.IntakeConstants.intake), new Solenoid(Constants.IntakeConstants.lSolenoid),
				new Solenoid(Constants.IntakeConstants.rSolenoid),
				new Ultrasonic(Constants.IntakeConstants.ultraSonicPing, Constants.IntakeConstants.ultraSonicEcho));

	}

	/**
	 * Use this method to define your button->command mappings. Buttons can be
	 * created by instantiating a {@link GenericHID} or one of its subclasses
	 * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
	 * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
	 */
	private void configureButtonBindings() {
	}

	/**
	 * Use this to pass the autonomous command to the main {@link Robot} class.
	 *
	 * @return the command to run in autonomous
	 */
	public Command getAutonomousCommand() {
		// An ExampleCommand will run in autonomous
		return null;
	}

	/**
	 * Get the controller instance
	 * 
	 * @return The controller instance
	 */
	public static Controller getController() {
		return m_controller;
	}

	public static DriveTrainSubsystem getDriveTrain() {
		return m_driveTrain;
	}

	public static IntakeSubsystem getIntake() {
		return m_intake;
	}

}
