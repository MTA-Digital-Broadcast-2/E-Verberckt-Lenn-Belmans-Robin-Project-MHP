package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;

//Klasse van Hcomponent overerven
public class MijnComponent extends HComponent
{
    public MijnComponent(int xPos, int yPos, int height, int width)
    {
        this.setBounds(xPos, yPos, height, width);
    }
    
    //Paint methode overschrijven
    public void paint (Graphics g)
    {
        g.setColor(new DVBColor(100, 100, 100, 178));
        g.fillRect(0, 0, 100, 100);
        g.setColor(Color.white);
        g.drawString("Tekst1", 15, 20);
    }
}
