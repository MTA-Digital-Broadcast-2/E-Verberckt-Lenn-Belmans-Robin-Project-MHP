package hellotvxlet;

import java.util.TimerTask;

public class MijnTimerTask extends TimerTask
{
    private MijnComponent mc;
    
    public void run()
    {
        System.out.println("Timer method");
        mc.setBounds(mc.getX() + 1, mc.getY(), mc.getHeight(), mc.getWidth());
    }
    
    public void setComponent(MijnComponent mc)
    {
        this.mc = mc;
    }
    
    public MijnComponent getComponent()
    {
        return this.mc;
    }
}
