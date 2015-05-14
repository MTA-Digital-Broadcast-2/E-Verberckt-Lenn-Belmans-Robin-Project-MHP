package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.*;


public class HelloTVXlet implements Xlet 
{
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    
    public void initXlet(XletContext context) 
    {
      if(debug) System.out.println("Xlet initialiseren");
      this.actueleXletContext = context;

      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      
      MijnComponent mc = new MijnComponent(50, 50, 200, 200);
      MijnComponent mcShadow = new MijnComponent(60, 60, 200, 200);
      scene.add(mc);
      scene.add(mcShadow);
    }

    public void startXlet() 
    {
        if(debug) System.out.println("Xlet starten.");
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() 
    {
     
    }

    public void destroyXlet(boolean unconditional) 
    {
     
    }
}
