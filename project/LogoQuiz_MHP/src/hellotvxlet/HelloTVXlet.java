package Oef1;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
import java.awt.*;
import java.awt.event.*;
import org.havi.ui.*;
import org.dvb.ui.*;
import org.havi.ui.event.*;

/**
 * Just a simple xlet that draws a String in the center of the screen.
 */
public class HelloTVXlet implements Xlet, HActionListener {
    
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    private HTextButton knop1;
    private HStaticText label1;
    
    public void initXlet(XletContext context) {
        if(debug) System.out.println("Xlet initialiseren.");
        this.actueleXletContext = context;
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
    
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        label1 = new HStaticText("Welkom op de logoquiz");
        label1.setLocation(100, 50);
        label1.setSize(400, 50);
        label1.setBackground(new DVBColor(255,255,255,179));
        label1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        knop1 = new HTextButton("Start");
        knop1.setLocation(100,100);
        knop1.setSize(250,50);
        knop1.setBackground(new DVBColor(0,0,0,179));
        knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        knop1.setActionCommand("Het spel wordt gestart");
        knop1.addHActionListener(this);
        
        scene.add(knop1);
        scene.add(label1);
        
        knop1.requestFocus();
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
    
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());
    }
}
