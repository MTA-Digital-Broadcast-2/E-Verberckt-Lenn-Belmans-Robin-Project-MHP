package hellotvxlet;

import javax.tv.xlet.*;
import org.havi.ui.*;
import org.davic.resources.*;
import org.havi.ui.event.*;
import java.awt.event.*;
import org.dvb.event.*;
import org.dvb.ui.*;

public class HelloTVXlet implements Xlet,ResourceClient, HBackgroundImageListener, UserEventListener
{
    private HScreen screen;
    private HBackgroundDevice bgDevice;
    private HBackgroundConfigTemplate bgTemplate;
    private HStillImageBackgroundConfiguration bgConfiguration;
    private HBackgroundImage imgPizza1=new HBackgroundImage("pizza1.m2v");
    private HBackgroundImage imgPizza2=new HBackgroundImage("pizza2.m2v");
    private HBackgroundImage imgPizza3=new HBackgroundImage("pizza3.m2v");
    private HBackgroundImage imgPizza4=new HBackgroundImage("pizza4.m2v");

    
    public void notifyRelease(ResourceProxy proxy)
    {
        
    }
    
    public void release(ResourceProxy proxy)
    {
        
    }
    
    public boolean requestRelease(ResourceProxy proxy, Object requestData)
    {
        return false;
    }
    
    public void imageLoaded(HBackgroundImageEvent e)
    {
        try
        {
            bgConfiguration.displayImage(imgPizza1);
        }
        catch (Exception s)
        {
            System.out.println(s.toString());
        }
    }
    
    public void imageLoadFailed(HBackgroundImageEvent e)
    {
        System.out.println("Image kan niet geladen worden.");
    }
    
    public void initXlet(XletContext context) 
    {        
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
            System.out.println("Background image device cannot be reserved!");
        }
        
        // Template maken
        bgTemplate = new HBackgroundConfigTemplate();
        
        // Configuratieinstelling "STILL_IMAGE"
        bgTemplate.setPreference(HBackgroundConfigTemplate.STILL_IMAGE, HBackgroundConfigTemplate.REQUIRED);
        
        // Configuratie aanvragen en activeren indien OK
        bgConfiguration = (HStillImageBackgroundConfiguration)bgDevice.getBestConfiguration(bgTemplate);
        try
        {
            bgDevice.setBackgroundConfiguration(bgConfiguration);
        }
        catch (java.lang.Exception e)
        {
            System.out.println(e.toString());
        }
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
    }

    public void startXlet() 
    {
        System.out.println("startXlet");
        // Image laden
        imgPizza1.load(this);
        imgPizza2.load(this);
        imgPizza3.load(this);
        imgPizza4.load(this);
    }

    public void pauseXlet() 
    {
        System.out.println("pauseXlet");
    }

    public void destroyXlet(boolean unconditional) 
    {
        System.out.println("destroyXlet");
        imgPizza1.flush();
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
                    try
                    {
                        bgConfiguration.displayImage(imgPizza1);
                    }
                    catch (Exception s)
                    {
                        System.out.println(s.toString());
                    }
                                        
                    break;
                case HRcEvent.VK_DOWN:
                    System.out.println("VK_DOWN is PRESSED");
                    
                    try
                    {
                        bgConfiguration.displayImage(imgPizza2);
                    }
                    catch (Exception s)
                    {
                        System.out.println(s.toString());
                    }
                     
                    break;
                case HRcEvent.VK_RIGHT:
                    System.out.println("VK_RIGHT is PRESSED");
                    
                    try
                    {
                        bgConfiguration.displayImage(imgPizza3);
                    }
                    catch (Exception s)
                    {
                        System.out.println(s.toString());
                    }
                     
                    break;
                case HRcEvent.VK_LEFT:
                    System.out.println("VK_LEFT is PRESSED");
                    
                    try
                    {
                        bgConfiguration.displayImage(imgPizza4);
                    }
                    catch (Exception s)
                    {
                        System.out.println(s.toString());
                    } 
                    break;
            }
        }
    }
}
