package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;
import org.dvb.ui.*;

public class MijnComponent extends HComponent {
    public MijnComponent() {
        this.setBounds(0, 0, 100, 100);
    }
    
    public MijnComponent(int x, int y, int length, int width) {
        this.setBounds(x,y,length,width);
    }
     
    public void paint(Graphics g) {
        g.setColor(new DVBColor(0, 127, 255, 179));
        g.fillRect(0,0,100,100);
        g.setColor(Color.YELLOW);
        g.drawString("Tekst1", 15,20);
    }
}
