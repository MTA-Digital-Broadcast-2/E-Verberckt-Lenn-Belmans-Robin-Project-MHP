package hellotvxlet;

import org.havi.ui.*;
import java.awt.*;

// Klasse van Hcomponent overerven
public class MijnComponent extends HComponent
{
    private Image bmap;
    private MediaTracker mtrack;
    
    // Plaats en locatie instellen in de constructor
    public MijnComponent (String bitmapnaam, int x, int y)
    {
        bmap = this.getToolkit().getImage(bitmapnaam);
        mtrack = new MediaTracker(this);
        mtrack.addImage(bmap, 0);
        try
        {
            mtrack.waitForAll(); // WACHT TOT ALLE BITMAPS GELADEN ZIJN
        }
        catch (Exception e)
            {
                System.out.println(e.toString());
            }
        this.setBounds(x, y, bmap.getWidth(null), bmap.getWidth(null));
            // Opgegeven plaats en afmeting van de bitmap
    }
    
    // Paint methode overriden
    public void paint(Graphics g)
    {
        g.drawImage(bmap, 0, 0, null);
    }
}
