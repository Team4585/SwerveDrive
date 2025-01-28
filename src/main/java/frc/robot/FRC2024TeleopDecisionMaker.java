package frc.robot;

import com.ctre.phoenix.motorcontrol.IFollower;

import edu.wpi.first.wpilibj.Servo;

public class FRC2024TeleopDecisionMaker {
  private FRC2024Joystick m_TheJoystick = new FRC2024Joystick();
  private FRC2024WeaponsJoystick m_TheWeaponsJoystick = new FRC2024WeaponsJoystick();
  private FRC2024Controller m_TheController = new FRC2024Controller();
  private FRC2024WeaponsController m_TheWeaponsController = new FRC2024WeaponsController();
  Servo actuator = new Servo(0);
  
  boolean isOut = true;

  private FRC2024Chassis m_Chassis;

  boolean isFieldOriented = false;

  FRC2024TeleopDecisionMaker(){

    m_Chassis = new FRC2024Chassis();
  }

  public void initialize(){
  }

  public void doDecisions(){

    m_Chassis.setTargSpeed(m_TheJoystick.getForwardBackwardValue(),
      -m_TheJoystick.getSideToSideValue(),
      -m_TheJoystick.getTwistValue(),
      isFieldOriented
      );

      if (m_TheJoystick.button7PressEvent()) {
        if (isFieldOriented) {
          isFieldOriented = false;
        }else{
          isFieldOriented = true;
        }
      }

      if(m_TheJoystick.triggerPressEvent()){
        if(isOut){
          actuator.setAngle(50);
        }else{
          actuator.setAngle(130);
        }
      }

      if (m_TheJoystick.button9PressEvent()) {
        m_Chassis.resetPigeon();
      }



  }

}
