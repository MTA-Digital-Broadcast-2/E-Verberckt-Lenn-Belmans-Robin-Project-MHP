package hellotvxlet;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import java.awt.*;
import org.havi.ui.*;
import org.dvb.ui.*;

/**
 * Just a simple xlet that draws a String in the center of the screen.
 */
public class HelloTVXlet implements Xlet {
    
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    
    public void initXlet(XletContext context) {
        if(debug) System.out.println("Xlet initialiseren.");
        this.actueleXletContext = context;
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
    
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        MijnComponent mc = new MijnComponent(0,0,100,100);
        scene.add(mc);
    }

    public void startXlet() {
        if(debug) System.out.println("Xlet starten.");
        
        scene.validate();
        scene.setVisible(true);
    }

    public void pauseXlet() {

    }

    public void destroyXlet(boolean unconditional) {
        
    }
}
