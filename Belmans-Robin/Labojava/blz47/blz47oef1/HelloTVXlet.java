package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.*;
import java.awt.event.*;
import org.havi.ui.event.*;
import org.dvb.event.*;

public class HelloTVXlet implements Xlet, UserEventListener
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
      
      mc = new MijnComponent("spaceship.png", 100, 100);
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      scene.add(mc);
    }

    public void startXlet() 
    {
        System.out.println("Xlet gestart");
        // EventManager aanvragen
        EventManager manager = EventManager.getInstance();
        
        // Repository
        UserEventRepository repository = new UserEventRepository("Voorbeeld");
        
        // Events toevoegen
        repository.addKey( org.havi.ui.event.HRcEvent.VK_UP);
        repository.addKey( org.havi.ui.event.HRcEvent.VK_DOWN);
        repository.addKey( org.havi.ui.event.HRcEvent.VK_LEFT);
        repository.addKey( org.havi.ui.event.HRcEvent.VK_RIGHT);
        
        // Bekend maken bij EventManager
        manager.addUserEventListener(this, repository);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() 
    {
     
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException 
    {
       
    }
       
    public void userEventReceived(org.dvb.event.UserEvent e)
    {
        if (e.getType() == KeyEvent.KEY_PRESSED)
        {
            System.out.println("Pushed Button");
            
            switch(e.getCode())
            {
                case HRcEvent.VK_UP:
                    System.out.println("VK_UP is PRESSED");
                    mc.setBounds(mc.getBounds().x, mc.getBounds().y + 10, mc.getHeight(), mc.getWidth());                    
                    break;
                case HRcEvent.VK_DOWN:
                    System.out.println("VK_DOWN is PRESSED");
                    mc.setBounds(mc.getBounds().x, mc.getBounds().y - 10, mc.getHeight(), mc.getWidth()); 
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("VK_RIGHT is PRESSED");
                    mc.setBounds(mc.getBounds().x + 10, mc.getBounds().y, mc.getHeight(), mc.getWidth()); 
                    break;
                case HRcEvent.VK_LEFT:
                    System.out.println("VK_LEFT is PRESSED");
                    mc.setBounds(mc.getBounds().x - 10, mc.getBounds().y, mc.getHeight(), mc.getWidth()); 
                    break;
            }
        }
    }
}
