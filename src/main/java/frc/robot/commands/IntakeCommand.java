/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.IntakeSubsystem;

public class IntakeCommand extends CommandBase {

	private IntakeSubsystem m_intake;

	boolean currentBoolean, previousBoolean;

	int ballCount;

	/**
	 * Creates a new IntakeCommand.
	 */
	public IntakeCommand(IntakeSubsystem Intake) {
		// Use addRequirements() here to declare subsystem dependencies.
		m_intake = Intake;
		addRequirements(m_intake);
	}

	// Called when the command is initially scheduled.
	@Override
	public void initialize() {
		m_intake.retractIntake();
		m_intake.beltOff();
	}

	// Called every time the scheduler runs while the command is scheduled.
	@Override
	public void execute() {
		if (RobotContainer.getController().getBButton() == true) {
			m_intake.toggleIntake();
		}
		if (m_intake.hasSeenBall()) {
			m_intake.beltOn();
			currentBoolean = true;
		} else {
			m_intake.beltOff();
			currentBoolean = false;
		}
		if (currentBoolean == false && previousBoolean == true) {
			ballCount++;
		}
		previousBoolean = currentBoolean;
	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) {
		m_intake.retractIntake();
		m_intake.beltOff();
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished() {
		return false;
	}
}
