package hellotvxlet;

import javax.tv.xlet.*;
import org.dvb.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;

//Stap 1: Klassen onder org.havi.ui verkort noteren
import org.havi.ui.*;

public class HelloTVXlet implements Xlet, HActionListener
{
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug=true;
    // debuggen activeren of niet?
    private HTextButton btnElephant, btnMoon, btnBall, btnEgg;
    private HStaticText lblQuestion;

    public void initXlet(XletContext context) throws XletStateChangeException
    {
      if(debug) System.out.println("Xlet initialiseren");
      this.actueleXletContext = context;

      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      
      lblQuestion = new HStaticText("Which of these is the biggest?");
      
      lblQuestion.setLocation(15, 30);
      lblQuestion.setSize(300,40);
      lblQuestion.setBackground(new DVBColor(0, 0, 0, 179));
      lblQuestion.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btnElephant = new HTextButton("Elephant");
      btnElephant.setLocation(10,100);
      btnElephant.setSize(150,50);
      btnElephant.setBackground(new DVBColor(0, 0, 0, 179));
      btnElephant.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btnMoon = new HTextButton("Moon");
      btnMoon.setLocation(10,160);
      btnMoon.setSize(150,50);
      btnMoon.setBackground(new DVBColor(0, 0, 0, 179));
      btnMoon.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      // Stap 3: object aanmaken
      btnBall = new HTextButton("Ball");
      btnBall.setLocation(170,100);
      btnBall.setSize(150,50);
      btnBall.setBackground(new DVBColor(0, 0, 0, 179));
      btnBall.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btnEgg = new HTextButton("Egg");
      btnEgg.setLocation(170,160);
      btnEgg.setSize(150,50);
      btnEgg.setBackground(new DVBColor(0, 0, 0, 179));
      btnEgg.setBackgroundMode(HVisible.BACKGROUND_FILL);
                  
      btnElephant.setFocusTraversal(btnMoon, btnMoon, btnEgg, btnBall); // op, neer, links, rechts
      btnMoon.setFocusTraversal(btnElephant, btnElephant, btnBall, btnEgg); // op, neer, links, rechts
      btnBall.setFocusTraversal(btnEgg, btnEgg, btnElephant, btnMoon); // op, neer, links, rechts
      btnEgg.setFocusTraversal(btnBall, btnBall, btnMoon, btnElephant); // op, neer, links, rechts
      
      scene.add(lblQuestion);
      scene.add(btnElephant);
      scene.add(btnMoon);
      scene.add(btnBall);
      scene.add(btnEgg);
      
      btnElephant.requestFocus();
      
      btnElephant.setActionCommand("Wrong answer! Try again!");
      btnMoon.setActionCommand("Right answer! Congratulations!");
      btnBall.setActionCommand("Wrong answer! Try again!");
      btnEgg.setActionCommand("Wrong answer! Try again!");
      
      btnElephant.addHActionListener(this);
      btnMoon.addHActionListener(this);
      btnBall.addHActionListener(this);
      btnEgg.addHActionListener(this);
    }

    public void startXlet() 
    {
        if(debug) System.out.println("Xlet starten");
        //Scene zichtbaar maken
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() 
    {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException
    {
     
    }
    
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getActionCommand());
        
        if(e.getActionCommand().equals("Wrong answer! Try again!"))
        {
            btnElephant.requestFocus();
        }
    }
}
