package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.*;
import java.util.Timer;

public class HelloTVXlet implements Xlet
{
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    private MijnComponent mc;
    
    public void initXlet(XletContext context) throws XletStateChangeException
    {
      if(debug) System.out.println("Xlet initialiseren");
      this.actueleXletContext = context;

      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
      
      mc = new MijnComponent("sterren.png", 715, 570);
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      scene.add(mc);
    }

    public void startXlet() 
    {
        System.out.println("Xlet gestart");

        MijnTimerTask objMijnTimerTask = new MijnTimerTask();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(objMijnTimerTask, 0, 10);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() 
    {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException 
    {
       
    }
}
