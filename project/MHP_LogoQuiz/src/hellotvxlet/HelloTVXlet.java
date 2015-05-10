package hellotvxlet;

import org.dvb.ui.*;
import java.awt.event.*;
import javax.tv.xlet.*;
import org.havi.ui.event.*;
import org.havi.ui.*;
import org.davic.resources.*;

public class HelloTVXlet implements Xlet, HActionListener, ResourceClient,
HBackgroundImageListener
{ 
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage agrondimg = new HBackgroundImage("background.png");
    private XletContext actueleXletContext;
    private HScene scene;
    private boolean debug=true;
    private HTextButton btnAnswerA, btnAnswerC, btnAnswerB, btnAnswerD, btnClose, btnStart;
    private HStaticText lblQuestion, lblScore, lblWelcome, lblWelcome2, lblThanks, lblYourTotalScore;
    private int intScore = 0;
    private MijnComponent team0;
    private MijnComponent team1;
    private MijnComponent team2;
    private MijnComponent team3;
    private MijnComponent team4;
    private MijnComponent team5;
    private MijnComponent team6;
    private MijnComponent team7;
    private MijnComponent team8;
    private MijnComponent team9;
    private MijnComponent team10;
    private MijnComponent team11;
    private MijnComponent team12;
    private MijnComponent team13;
    private MijnComponent team14;
    //private MijnComponent[] teamArray;
    private int i = 0;
    
    public void notifyRelease (ResourceProxy proxy)
    { 
    
    }
    
    public void release (ResourceProxy proxy)
    {
    
    }
    
    public boolean requestRelease (ResourceProxy proxy , Object requestData) 
    {
        return false; 
    }
    
    public void imageLoaded(HBackgroundImageEvent e)
    {
        try
        {
            bgConfiguration.displayImage(agrondimg);
        }
        catch (Exception s)
        {
            System.out.println(s.toString());
        }
    }

    public void imageLoadFailed (HBackgroundImageEvent e)
    {
        System.out.println("Image kan niet geladen worden.");
    }

    public void initXlet(XletContext context) throws XletStateChangeException
    {
      if(debug) System.out.println("Xlet initialiseren");
      this.actueleXletContext = context;

      HSceneTemplate sceneTemplate = new HSceneTemplate();
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
      
      sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
      
      scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
      
      // HScreen object opvragen
      screen = HScreen.getDefaultHScreen();
      // HBackgroundDevice opvragen
      bgDevice = screen.getDefaultHBackgroundDevice();
      // HBackgroundDevice proberen te reserveren
      if (bgDevice.reserveDevice(this))
      {
          System.out.println("BackgroundImage device has been reserved");
      }
      else
      {
          System.out.println("Background image device cannot be reserved");
      }
      // Template maken
      bgTemplate = new HBackgroundConfigTemplate();
      // Configuratieinstelling "STILL_IMAGE"
      bgTemplate.setPreference (HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
      // Conf igurat ie aanvragen en act iveren indien OK
      bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);

      try 
      {
          bgDevice.setBackgroundConfiguration(bgConfiguration);
      }
      catch(java.lang.Exception e)
      {
          System.out.println(e.toString());
      }
      /*teamArray = new MijnComponent[14];
      teamArray[0] = new MijnComponent("anderlecht.png", 217, 85);
      teamArray[1] = new MijnComponent("cerclebrugge.png", 217, 85);
      teamArray[2] = "zultewaregem.png";
      teamArray[3] = "westerlo.png";
      teamArray[4] = "waaslandbeveren.png";
      teamArray[5] = "standard.png";
      teamArray[6] = "oostende.png";
      teamArray[7] = "mechelen.png";
      teamArray[8] = "lokeren.png";
      teamArray[9] = "kortrijk.png";
      teamArray[10] = "gent.png";
      teamArray[11] = "genk.png";
      teamArray[12] = "clubbrugge.png";
      teamArray[13] = "charleroi.png"; */
              
      team0 = new MijnComponent("anderlecht.png", 245, 105);
      team1 = new MijnComponent("cerclebrugge.png", 245, 105);
      team2 = new MijnComponent("zultewaregem.png", 245, 105);
      team3 = new MijnComponent("westerlo.png", 245, 105);
      team4 = new MijnComponent("waaslandbeveren.png", 245, 105);
      team5 = new MijnComponent("standard.png", 245, 105);
      team6 = new MijnComponent("oostende.png", 210, 70);
      team7 = new MijnComponent("mechelen.png", 245, 105);
      team8 = new MijnComponent("lokeren.png", 245, 105);
      team9 = new MijnComponent("kortrijk.png", 245, 105);
      team10 = new MijnComponent("gent.png", 245, 105);
      team11 = new MijnComponent("genk.png", 245, 105);
      team12 = new MijnComponent("clubbrugge.png", 245, 105);
      team13 = new MijnComponent("charleroi.png", 245, 105);
      team14 = new MijnComponent("lierse.png", 245, 105);
      
      lblQuestion = new HStaticText("Which team is this?");
      lblQuestion.setLocation(100, 40);
      lblQuestion.setSize(500,50);
      lblQuestion.setBackground(new DVBColor(0, 0, 0, 179));
      lblQuestion.setBackgroundMode(HVisible.BACKGROUND_FILL);
      lblQuestion.setVisible(false);
      
      lblScore = new HStaticText(Integer.toString(intScore));
      lblScore.setLocation(600, 480);
      lblScore.setSize(50,50);
      lblScore.setBackground(new DVBColor(0, 0, 0, 179));
      lblScore.setBackgroundMode(HVisible.BACKGROUND_FILL);
      lblScore.setVisible(false);
      
      lblWelcome = new HStaticText("Welcome to our game!");
      lblWelcome.setLocation(0,240);
      lblWelcome.setSize(700,50);
      lblWelcome.setBackground(new DVBColor(0, 0, 0, 179));
      lblWelcome.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      lblWelcome2 = new HStaticText("Made by Lenn Verbeckt and Robin Belmans!");
      lblWelcome2.setLocation(0,180);
      lblWelcome2.setSize(700,50);
      lblWelcome2.setBackground(new DVBColor(0, 0, 0, 179));
      lblWelcome2.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      lblThanks = new HStaticText("Thank you for playing our game!");
      lblThanks.setLocation(0,90);
      lblThanks.setSize(700,50);
      lblThanks.setBackground(new DVBColor(0, 0, 0, 179));
      lblThanks.setBackgroundMode(HVisible.BACKGROUND_FILL);
      lblThanks.setVisible(false);
      
      lblYourTotalScore = new HStaticText("You total score is:");
      lblYourTotalScore.setLocation(0,150);
      lblYourTotalScore.setSize(700,50);
      lblYourTotalScore.setBackground(new DVBColor(0, 0, 0, 179));
      lblYourTotalScore.setBackgroundMode(HVisible.BACKGROUND_FILL);
      lblYourTotalScore.setVisible(false);
      
      btnStart = new HTextButton("Start");
      btnStart.setLocation(245,330);
      btnStart.setSize(200,50);
      btnStart.setBackground(new DVBColor(0, 0, 0, 179));
      btnStart.setBackgroundMode(HVisible.BACKGROUND_FILL);
      
      btnAnswerA = new HTextButton("A. Anderlecht");
      btnAnswerA.setLocation(60,330);
      btnAnswerA.setSize(250,50);
      btnAnswerA.setBackground(new DVBColor(0, 0, 0, 179));
      btnAnswerA.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnAnswerA.setVisible(false);

      btnAnswerB = new HTextButton("B. Standard");
      btnAnswerB.setLocation(385,330);
      btnAnswerB.setSize(250,50);
      btnAnswerB.setBackground(new DVBColor(0, 0, 0, 179));
      btnAnswerB.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnAnswerB.setVisible(false);
            
      btnAnswerC = new HTextButton("C. Club Brugge");
      btnAnswerC.setLocation(60,400);
      btnAnswerC.setSize(250,50);
      btnAnswerC.setBackground(new DVBColor(0, 0, 0, 179));
      btnAnswerC.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnAnswerC.setVisible(false);
      
      btnAnswerD = new HTextButton("D. KAA Gent");
      btnAnswerD.setLocation(385,400);
      btnAnswerD.setSize(250,50);
      btnAnswerD.setBackground(new DVBColor(0, 0, 0, 179));
      btnAnswerD.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnAnswerD.setVisible(false);
      
      btnClose = new HTextButton("Close");
      btnClose.setLocation(245,480);
      btnClose.setSize(200,50);
      btnClose.setBackground(new DVBColor(0, 0, 0, 179));
      btnClose.setBackgroundMode(HVisible.BACKGROUND_FILL);
      btnClose.setVisible(false);
                  
      btnAnswerA.setFocusTraversal(btnAnswerC, btnAnswerC, btnAnswerD, btnAnswerB);
      btnAnswerB.setFocusTraversal(btnAnswerD, btnAnswerD, btnAnswerA, btnAnswerC);
      btnAnswerC.setFocusTraversal(btnAnswerA, btnClose, btnAnswerB, btnAnswerD);
      btnAnswerD.setFocusTraversal(btnAnswerB, btnClose, btnAnswerC, btnAnswerA);
      btnClose.setFocusTraversal(btnAnswerC, btnAnswerA, btnAnswerC, btnAnswerD);
      
      scene.add(lblQuestion);
      scene.add(btnAnswerA);
      scene.add(btnAnswerC);
      scene.add(btnAnswerB);
      scene.add(btnAnswerD);
      scene.add(btnClose);
      scene.add(btnStart);
      scene.add(lblScore);
      scene.add(lblWelcome);
      scene.add(lblWelcome2);
      scene.add(lblThanks);
      scene.add(lblYourTotalScore);
      
      btnStart.requestFocus();
      
      btnAnswerA.setActionCommand("This is the right answer!");
      btnAnswerB.setActionCommand("Wrong answer!");
      btnAnswerC.setActionCommand("Wrong answer!");
      btnAnswerD.setActionCommand("Wrong answer!");
      btnClose.setActionCommand("stop");
      btnStart.setActionCommand("Welcome!");
      
      btnAnswerA.addHActionListener(this);
      btnAnswerC.addHActionListener(this);
      btnAnswerB.addHActionListener(this);
      btnAnswerD.addHActionListener(this);
      btnClose.addHActionListener(this);
      btnStart.addHActionListener(this);
    }

    public void startXlet() 
    {
        if(debug) System.out.println("Xlet starten");
        scene.validate();
        scene.setVisible(true);
        agrondimg.load(this);
    }

    public void pauseXlet() 
    {
        System.out.println("pauseXlet");
    }

    public void destroyXlet(boolean unconditional) throws XletStateChangeException
    {
        System.out.println("destroyXlet");
        agrondimg.flush();
    }
    
    public void actionPerformed(ActionEvent e)
    {
        System.out.println(e.getActionCommand());
        
        if(e.getActionCommand().equals("This is the right answer!"))
        {
            btnAnswerA.requestFocus();
            intScore++;
            lblScore.setTextContent(Integer.toString(intScore), HState.NORMAL_STATE);
            System.out.println(intScore);
            i++;
            
            switch (i)
            {
                case 1:
                    scene.remove(team0);
                    scene.add(team1);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Club Brugge", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Cercle Brugge", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Genk", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Mechelen", HState.NORMAL_STATE);
                   
                    btnAnswerA.setActionCommand("Wrong answer!");
                    btnAnswerB.setActionCommand("This is the right answer!");
                    btnAnswerC.setActionCommand("Wrong answer!");
                    btnAnswerD.setActionCommand("Wrong answer!");
                    break;
                
                case 2:
                    scene.remove(team1);
                    scene.add(team2);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Waasland Beveren", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Genk", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Zulte Waregem", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Club Brugge", HState.NORMAL_STATE);
                    
                    btnAnswerA.setActionCommand("Wrong answer!");
                    btnAnswerB.setActionCommand("Wrong answer!");
                    btnAnswerC.setActionCommand("This is the right answer!");
                    btnAnswerD.setActionCommand("Wrong answer!");
                    break;
                    
                case 3:
                    scene.remove(team2);
                    scene.add(team3);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Mechelen", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Lierse", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Oostende", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Westerlo", HState.NORMAL_STATE);
                    
                    btnAnswerA.setActionCommand("Wrong answer!");
                    btnAnswerB.setActionCommand("Wrong answer!");
                    btnAnswerC.setActionCommand("Wrong answer!");
                    btnAnswerD.setActionCommand("This is the right answer!");
                    break;
                
                case 4:
                    scene.remove(team3);
                    scene.add(team4);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Waasland Beveren", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Zulte Waregem", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Charleroi", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Lierse", HState.NORMAL_STATE);
                    
                    btnAnswerA.setActionCommand("This is the right answer!");
                    btnAnswerB.setActionCommand("Wrong answer!");
                    btnAnswerC.setActionCommand("Wrong answer!");
                    btnAnswerD.setActionCommand("Wrong answer!");
                    break;
                
                case 5:
                    scene.remove(team4);
                    scene.add(team5);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Zulte Waregem", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Standard", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Anderlecht", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Kortrijk", HState.NORMAL_STATE);
                    
                    btnAnswerA.setActionCommand("Wrong answer!");
                    btnAnswerB.setActionCommand("This is the right answer!");
                    btnAnswerC.setActionCommand("Wrong answer!");
                    btnAnswerD.setActionCommand("Wrong answer!");
                    break;
                    
                case 6:
                    scene.remove(team5);
                    scene.add(team6);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Lierse", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Waasland Beveren", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Oostende", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Kortrijk", HState.NORMAL_STATE);
                    
                    btnAnswerA.setActionCommand("Wrong answer!");
                    btnAnswerB.setActionCommand("Wrong answer!");
                    btnAnswerC.setActionCommand("This is the right answer!");
                    btnAnswerD.setActionCommand("Wrong answer!");
                    break;
                    
                case 7:
                    scene.remove(team6);
                    scene.add(team7);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Genk", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Lierse", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Lokeren", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Mechelen", HState.NORMAL_STATE);
                    
                    btnAnswerA.setActionCommand("Wrong answer!");
                    btnAnswerB.setActionCommand("Wrong answer!");
                    btnAnswerC.setActionCommand("Wrong answer!");
                    btnAnswerD.setActionCommand("This is the right answer!");
                    break;
                
                case 8:
                    scene.remove(team7);
                    scene.add(team8);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Lokeren", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Club Brugge", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Charleroi", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Westerlo", HState.NORMAL_STATE);
                    
                    btnAnswerA.setActionCommand("This is the right answer!");
                    btnAnswerB.setActionCommand("Wrong answer!");
                    btnAnswerC.setActionCommand("Wrong answer!");
                    btnAnswerD.setActionCommand("Wrong answer!");
                    break;
                    
                case 9:
                    scene.remove(team8);
                    scene.add(team9);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Lokeren", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Kortrijk", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Cercle Brugge", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Anderlecht", HState.NORMAL_STATE);
                    
                    btnAnswerA.setActionCommand("Wrong answer!");
                    btnAnswerB.setActionCommand("This is the right answer!");
                    btnAnswerC.setActionCommand("Wrong answer!");
                    btnAnswerD.setActionCommand("Wrong answer!");
                    break;
                    
                case 10:
                    scene.remove(team9);
                    scene.add(team10);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Charleroi", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Standard", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Gent", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Lierse", HState.NORMAL_STATE);
                    
                    btnAnswerA.setActionCommand("Wrong answer!");
                    btnAnswerB.setActionCommand("Wrong answer!");
                    btnAnswerC.setActionCommand("This is the right answer!");
                    btnAnswerD.setActionCommand("Wrong answer!");
                    break;
                
                case 11:
                    scene.remove(team10);
                    scene.add(team11);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Gent", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Waasland Beveren", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Oostende", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Genk", HState.NORMAL_STATE);
                    
                    btnAnswerA.setActionCommand("Wrong answer!");
                    btnAnswerB.setActionCommand("Wrong answer!");
                    btnAnswerC.setActionCommand("Wrong answer!");
                    btnAnswerD.setActionCommand("This is the right answer!");
                    break;
                    
                case 12:
                    scene.remove(team11);
                    scene.add(team12);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Club Brugge", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Gent", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Kortrijk", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Cercle Brugge", HState.NORMAL_STATE);
                    
                    btnAnswerA.setActionCommand("This is the right answer!");
                    btnAnswerB.setActionCommand("Wrong answer!");
                    btnAnswerC.setActionCommand("Wrong answer!");
                    btnAnswerD.setActionCommand("Wrong answer!");
                    break;
                    
                case 13:
                    scene.remove(team12);
                    scene.add(team13);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Lokeren", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Charleroi", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Westerlo", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Genk", HState.NORMAL_STATE);
                    
                    btnAnswerA.setActionCommand("Wrong answer!");
                    btnAnswerB.setActionCommand("This is the right answer!");
                    btnAnswerC.setActionCommand("Wrong answer!");
                    btnAnswerD.setActionCommand("Wrong answer!");
                    break;
                    
                case 14:
                    scene.remove(team13);
                    scene.add(team14);
                    scene.repaint();
                    
                    btnAnswerA.setTextContent("A. Mechelen", HState.NORMAL_STATE);
                    btnAnswerB.setTextContent("B. Lokeren", HState.NORMAL_STATE);
                    btnAnswerC.setTextContent("C. Lierse", HState.NORMAL_STATE);
                    btnAnswerD.setTextContent("D. Anderlecht", HState.NORMAL_STATE);
                    
                    btnAnswerA.setActionCommand("Wrong answer!");
                    btnAnswerB.setActionCommand("Wrong answer!");
                    btnAnswerC.setActionCommand("This is the right answer!");
                    btnAnswerD.setActionCommand("Wrong answer!");
                    break;
                    
                case 15:
                    btnAnswerA.setVisible(false);
                    btnAnswerB.setVisible(false);
                    btnAnswerC.setVisible(false);
                    btnAnswerD.setVisible(false);
                    btnClose.setVisible(false);
                    lblQuestion.setVisible(false);
                    scene.remove(team14);
                    lblThanks.setVisible(true);
                    lblYourTotalScore.setVisible(true);
                    lblScore.setLocation(320,230);
            }
        }
        else if(e.getActionCommand().equals("stop"))
        {
            btnAnswerA.setVisible(false);
            btnAnswerB.setVisible(false);
            btnAnswerC.setVisible(false);
            btnAnswerD.setVisible(false);
            btnClose.setVisible(false);
            lblScore.setVisible(false);
            lblQuestion.setVisible(false);
            scene.setVisible(false);
        }
        else if(e.getActionCommand().equals("Welcome!"))
        {
            btnStart.setVisible(false);
            lblWelcome.setVisible(false);
            lblWelcome2.setVisible(false);
            btnAnswerA.setVisible(true);
            btnAnswerB.setVisible(true);
            btnAnswerC.setVisible(true);
            btnAnswerD.setVisible(true);
            btnClose.setVisible(true);
            lblScore.setVisible(true);
            lblQuestion.setVisible(true);
            scene.setVisible(true);
            scene.add(team0);
            btnAnswerA.requestFocus();
        }
        else if(e.getActionCommand().equals("Wrong answer!"))
        {
            intScore--;
            lblScore.setTextContent(Integer.toString(intScore), HState.NORMAL_STATE);
            System.out.println(intScore);
        }
    }
}

