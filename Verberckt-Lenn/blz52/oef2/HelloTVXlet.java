package hellotvxlet;

import javax.tv.xlet.*;
import java.awt.event.*;import java.util.Timer;
import org.davic.resources.ResourceClient;
import org.davic.resources.ResourceProxy;
import org.dvb.ui.DVBColor;
import org.havi.ui.event.HBackgroundImageEvent;
;
import org.dvb.event.*;
import org.havi.ui.*;
import org.havi.ui.event.*;

/**
 * Just a simple xlet that draws a String in the center of the screen.
 */
public class HelloTVXlet implements Xlet, UserEventListener, ResourceClient, HBackgroundImageListener {
    
    private HScreen screen;
    private int index = 1;
    private HScene scene;
    private XletContext actueleXletContext;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage agrondimg = new HBackgroundImage("pizza1.m2v");
    private HBackgroundImage pizza1 = new HBackgroundImage("pizza1.m2v");
    private HBackgroundImage pizza2 = new HBackgroundImage("pizza2.m2v");
    private HBackgroundImage pizza3 = new HBackgroundImage("pizza3.m2v");
    private HBackgroundImage pizza4 = new HBackgroundImage("pizza4.m2v");
    private HStaticText lblTekst = new HStaticText("Bestellijst: \n");
    private String txtBestelling = "Bestellijst:";
    
    public void initXlet(XletContext context) throws XletStateChangeException {
        screen = HScreen.getDefaultHScreen();
        this.actueleXletContext = context;
        HSceneTemplate sceneTemplate = new HSceneTemplate();
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_DIMENSION, new HScreenDimension(1.0f, 1.0f), HSceneTemplate.REQUIRED);
        sceneTemplate.setPreference(HSceneTemplate.SCENE_SCREEN_LOCATION, new HScreenPoint(0.0f, 0.0f), HSceneTemplate.REQUIRED);
        scene = HSceneFactory.getInstance().getBestScene(sceneTemplate);
        lblTekst.setLocation(350,65);
        lblTekst.setSize(275,265);
        lblTekst.setBackground(new DVBColor(255,255,255,179));
        lblTekst.setBackgroundMode(HVisible.BACKGROUND_FILL);
        
        scene.add(lblTekst);
        bgDevice = screen.getDefaultHBackgroundDevice();
        if(bgDevice.reserveDevice(this)) {
            System.out.println("Background image device has been reserved.");
        } else {
            System.out.println("Background image device cannot be reserved.");
        }
        bgTemplate = new HBackgroundConfigTemplate();
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
        try {
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        } catch(Exception e) {
            System.out.println(e.toString());
        }
        
    }

    public void startXlet() throws XletStateChangeException {
        System.out.println("startXlet");
        agrondimg.load(this);
        pizza1.load(this);
        pizza2.load(this);
        pizza3.load(this);
        pizza4.load(this);
        EventManager manager = EventManager.getInstance();
        UserEventRepository repository = new UserEventRepository("Voorbeeld"); 
        repository.addKey(HRcEvent.VK_UP);
        repository.addKey(HRcEvent.VK_DOWN);
        repository.addKey(HRcEvent.VK_LEFT);
        repository.addKey(HRcEvent.VK_RIGHT);
        repository.addKey(HRcEvent.VK_ENTER);
        
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
                    agrondimg = pizza1;
                    System.out.println("Trying to load pizza1.m2v.");
                    index = 1;
                    agrondimg.load(this);
                    break;
                case HRcEvent.VK_DOWN:
                    agrondimg = pizza2;
                    System.out.println("Trying to load pizza2.m2v.");
                    index = 2;
                    agrondimg.load(this);
                    break;
                case HRcEvent.VK_LEFT:
                    agrondimg = pizza3;
                    System.out.println("Trying to load pizza3.m2v.");
                    index = 3;
                    agrondimg.load(this);
                    break;
                case HRcEvent.VK_RIGHT:
                    agrondimg = pizza4;
                    System.out.println("Trying to load pizza4.m2v.");
                    index = 4;
                    agrondimg.load(this);
                    break;
                case HRcEvent.VK_ENTER:
                    switch(index) {
                        case 1:
                            txtBestelling += "\n1x Meat Lover's";
                            break;
                        case 2:
                            txtBestelling += "\n1x Pepperoni Lover's";
                            break;
                        case 3:
                            txtBestelling += "\n1x Cheese Lover's";
                            break;
                        case 4:
                            txtBestelling += "\n1x Veggi Lover's";
                            break;
                    }
                    lblTekst.setTextContent(txtBestelling, HVisible.NORMAL_STATE);
                    lblTekst.repaint();
                    break;
            }
        }
    }

    public boolean requestRelease(ResourceProxy proxy, Object requestData) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void release(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void notifyRelease(ResourceProxy proxy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void imageLoaded(HBackgroundImageEvent e) {
        try {
            bgConfiguration.displayImage(agrondimg);
        } catch(Exception s) {
            System.out.println(s.toString());
        }
    }

    public void imageLoadFailed(HBackgroundImageEvent e) {
        System.out.println("Image kan niet geladen worden.");
    }
}
