package hellotvxlet;

import javax.tv.xlet.*;
import java.awt.event.*;;
import org.dvb.event.*;
import org.havi.ui.*;
import org.havi.ui.event.*;

/**
 * Just a simple xlet that draws a String in the center of the screen.
 */
public class HelloTVXlet implements Xlet, UserEventListener {
    
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    private MijnComponent mc;
    
    public void initXlet(XletContext context) throws XletStateChangeException {
        if(debug) System.out.println("Xlet initialiseren.");
        this.actueleXletContext = context;
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
        
        mc = new MijnComponent("hellotvxlet/fb.jpg", 100,100);
        
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        scene.add(mc);
        
    }

    public void startXlet() throws XletStateChangeException {
        if(debug) System.out.println("Xlet starten.");
        
        EventManager manager = EventManager.getInstance();
        UserEventRepository repository = new UserEventRepository("Voorbeeld");
        repository.addKey(HRcEvent.VK_UP);
        repository.addKey(HRcEvent.VK_DOWN);
        repository.addKey(HRcEvent.VK_LEFT);
        repository.addKey(HRcEvent.VK_RIGHT);
        
        manager.addUserEventListener(this, repository);
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {

    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException {
        
    }
    
    public void userEventReceived(UserEvent e) {
        if(e.getType() == KeyEvent.KEY_PRESSED) {
            switch(e.getCode()) {
                case HRcEvent.VK_UP: 
                    mc.setBounds(mc.getBounds().x, mc.getBounds().y - 5, mc.getHeight(), mc.getWidth());
                    break;
                case HRcEvent.VK_DOWN:
                    mc.setBounds(mc.getBounds().x, mc.getBounds().y + 5, mc.getHeight(), mc.getWidth());
                    break;
                case HRcEvent.VK_LEFT:
                    mc.setBounds(mc.getBounds().x - 5, mc.getBounds().y, mc.getHeight(), mc.getWidth());
                    break;
                case HRcEvent.VK_RIGHT:
                    mc.setBounds(mc.getBounds().x + 5, mc.getBounds().y, mc.getHeight(), mc.getWidth());
                    break;
            }
        }
    }
}
