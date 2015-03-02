package hellotvxlet;

import javax.tv.xlet.Xlet;
import javax.tv.xlet.XletContext;
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
    private HTextButton knop2;
    private HTextButton knop3;
    private HStaticText label1;
    private HStaticText label2;
    private HStaticText lblScore2;
    public int Score = 0;
    
    public void initXlet(XletContext context) {
        if(debug) System.out.println("Xlet initialiseren.");
        this.actueleXletContext = context;
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
    
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        
        label1 = new HStaticText("Welkom op ons spel");
        label1.setLocation(100, 50);
        label1.setSize(500, 50);
        label1.setBackground(new DVBColor(255,255,255,179));
        label1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        label1.setVisible(true);
        
        label2 = new HStaticText("typ de text correct over ");
        label2.setLocation(200, 25);
        label2.setSize(300, 25);
        label2.setBackground(new DVBColor(255,255,255,179));
        label2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        label2.setVisible(false);
        
        lblScore2 = new HStaticText("0");
        lblScore2.setLocation(50, 75);
        lblScore2.setSize(200, 25);
        lblScore2.setBackground(new DVBColor(0,0,0,179));
        lblScore2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        lblScore2.setVisible(false);
        
        knop1 = new HTextButton("Start");
        knop1.setLocation(250,200);
        knop1.setSize(200,50);
        knop1.setBackground(new DVBColor(0,0,0,167));
        knop1.setBackgroundMode(HVisible.BACKGROUND_FILL);
        knop1.setActionCommand("start");
        knop1.addHActionListener(this);
        knop1.setVisible(true);
        
        knop2 = new HTextButton("Stop");
        knop2.setLocation(450,450);
        knop2.setSize(200,50);
        knop2.setBackground(new DVBColor(0,0,0,167));
        knop2.setBackgroundMode(HVisible.BACKGROUND_FILL);
        knop2.setActionCommand("stop");
        knop2.addHActionListener(this);
        knop2.setVisible(false);
        
        knop3 = new HTextButton("Enter");
        knop3.setLocation(50,450);
        knop3.setSize(200,50);
        knop3.setBackground(new DVBColor(0,0,0,167));
        knop3.setBackgroundMode(HVisible.BACKGROUND_FILL);
        knop3.setActionCommand("enter");
        knop3.addHActionListener(this);
        knop3.setVisible(false);
        
        knop1.setFocusTraversal(null, knop2, null, null);
        
        scene.add(knop1);
        scene.add(knop2);
        scene.add(knop3);
        scene.add(label1);
        scene.add(label2);
        scene.add(lblScore2);
        
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
        if (e.getActionCommand().equals("start"))
        {
            label1.setVisible(false);
            knop1.setVisible(false);
            label2.setVisible(true);
            knop2.setVisible(true);
            knop3.setVisible(true);
            lblScore2.setVisible(true);
            knop3.requestFocus();
            knop2.setFocusTraversal(null, null, knop3, null);
            knop3.setFocusTraversal(null, null, null, knop2);
        }
        else if (e.getActionCommand().equals("stop"))
        {
            label1.setVisible(true);
            knop1.setVisible(true);
            label2.setVisible(false);
            knop2.setVisible(false);
            knop3.setVisible(false);
            lblScore2.setVisible(false);
            knop1.requestFocus();
            Score=0;
            lblScore2.setTextContent(Integer.toString(Score), HState.NORMAL_STATE);
            
        }
        
        else if (e.getActionCommand().equals("enter"))
        {
            Score++;
            lblScore2.setTextContent(Integer.toString(Score), HState.NORMAL_STATE);
            System.out.println(Score);
        }
    }
}

