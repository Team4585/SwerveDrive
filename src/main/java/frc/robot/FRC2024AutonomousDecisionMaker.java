package frc.robot;

import java.util.List;

import frc.robot.autonomous.AutonomousTaskBase;
import frc.robot.autonomous.AutonomousTaskDispatcher;
import frc.robot.autonomous.tasks.AutoTaskStartSequence;

public class FRC2024AutonomousDecisionMaker {
  private List<AutonomousTaskBase> m_TaskList;
  private AutonomousTaskDispatcher m_autoTaskDispatcher;

  //private FRC2024Chassis m_Chassis;

  private double chassisKp = 0.007;
  private double chassisKi = 0.12;
  private double chassisKd = 0;
  private double chassisDt = 1;


  // Auto initialization

  FRC2024AutonomousDecisionMaker(){
   // m_TaskList = List.of(new AutoTaskTickCount(25), new AutoTaskHalt());
    
   /**
    * Wheeeeeeeeeee auto logic:
    * 1. Set shooter speed
      2. Wait 2s
      3. Set intake on
      4. Wait 1s
      5. Set intake off
      6. Set shooter speed 0
      7. Set intake on
      8. Drive forwards 1.2m
      9. Set intake off
      10. Drive backwards 1.2m
      11. Set shooter speed
      12. Wait 2s
      13. Set intake on
      14. Wait 1s
      15. Set shooter speed 0
      16. Wait 1s
      17. Set intake off
      18. Drive forwards 1.2m
    */
    

   //System.out.println("Initializing list");
   AutonomousTaskBase startTask = new AutoTaskStartSequence();

   m_TaskList = List.of(
    startTask
   );

    m_autoTaskDispatcher = new AutonomousTaskDispatcher(m_TaskList);

  }

  public void initialize(){
    m_autoTaskDispatcher.resetAuto();
  }

  public void doDecisions(){
    m_autoTaskDispatcher.RunAutoTask();
    //System.out.println("Entering autonomous decisions");
  }


}
