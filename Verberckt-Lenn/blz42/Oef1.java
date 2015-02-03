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
public class Oef1 implements Xlet, HActionListener {
    
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug = true;
    private HTextButton knop1, knop2, knop3, knop4;
    private HStaticText label1;
    
    public void initXlet(XletContext context) {
        if(debug) System.out.println("Xlet initialiseren.");
        this.actueleXletContext = context;
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
    
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        label1 = new HStaticText("Waar staat de eiffeltoren?");
        label1.setLocation(100, 50);
        label1.setSize(400, 50);
        label1.setBackground(new DVBColor(255,255,255,179));
        label1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        knop1 = new HTextButton("Frankfurt");
        knop1.setLocation(100,100);
        knop1.setSize(250,50);
        knop1.setBackground(new DVBColor(0,0,0,179));
        knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        knop1.setActionCommand("Knop 1 - Fout!");
        knop1.addHActionListener(this);
        
        knop2 = new HTextButton("Londen");
        knop2.setLocation(100,150);
        knop2.setSize(250,50);
        knop2.setBackground(new DVBColor(0,0,0,179));
        knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        knop2.setActionCommand("Knop 2 - Fout!");
        knop2.addHActionListener(this);
        
        knop3 = new HTextButton("Parijs");
        knop3.setLocation(100,200);
        knop3.setSize(250,50);
        knop3.setBackground(new DVBColor(0,0,0,179));
        knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        knop3.setActionCommand("Knop 3 - Juist!");
        knop3.addHActionListener(this);
        
        knop4 = new HTextButton("Kaapstad");
        knop4.setLocation(100,250);
        knop4.setSize(250,50);
        knop4.setBackground(new DVBColor(0,0,0,179));
        knop4.setBackgroundMode(HVisible.BACKGROUND_FILL);
        knop4.setActionCommand("Knop 4 - Fout!");
        knop4.addHActionListener(this);        
        
        knop1.setFocusTraversal(knop4, knop2, null, null); 
        knop2.setFocusTraversal(knop1, knop3, null, null);
        knop3.setFocusTraversal(knop2, knop4, null, null);
        knop4.setFocusTraversal(knop3, knop1, null, null);
        
        scene.add(knop1);
        scene.add(knop2);
        scene.add(knop3);
        scene.add(knop4);
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
