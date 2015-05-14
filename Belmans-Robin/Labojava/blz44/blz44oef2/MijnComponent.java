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
        g.setColor(new DVBColor(1, 1, 120, 158));
        g.fillRoundRect(0, 0, 150, 100, 50, 50);
        g.setColor(Color.yellow);
        g.drawString("Gele tekst", 30, 50);
    }
}
