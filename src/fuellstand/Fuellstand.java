package fuellstand;

import adruinoSignal.client.AdruinoClient;
import java.awt.Color;
import javax.swing.JFrame;

/**
 *
 * @author Klaus
 */
public class Fuellstand extends AdruinoClient {
  private static final Color farben[] = {Color.BLACK, Color.BLUE, Color.GREEN, Color.RED, Color.CYAN, Color.MAGENTA, Color.YELLOW, Color.PINK, Color.DARK_GRAY, Color.GRAY };
  private Behaelter[] behaelter;
  private FuellstandPanel anzeige = new FuellstandPanel(behaelter);
  private JFrame frame;
   
  public Fuellstand() {
    super("localhost");
    behaelter = new Behaelter[10];
    for (int i = 0; i < 10; i++) {
      behaelter[i] = new Behaelter(250, 150, farben[i]);
     // behaelter[i].setFuellstand(Math.random()*2000);
    }
    
    frame = new JFrame();
    frame.add(new FuellstandPanel(behaelter));
    frame.setTitle("Füllstand");
    frame.setSize(600, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }  

  @Override
  public void signalDoubleRecieved(String name, double value) {
   int nr = Integer.parseInt(name.split("_")[1]);
   behaelter[nr-1].setFuellstand(value);
   behaelter[nr-1].setVoll(value >= behaelter[nr-1].getWarnung());
   frame.repaint();
  }

  @Override
  public void signalBooleanRecieved(String name, boolean value) {
  }

  @Override
  public void signalStringRecieved(String name, String value) {
  }
  
  public static void main(String[] args) {
    new Fuellstand();
  }
}
