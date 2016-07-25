/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fuellstand.simu;

import fuellstand.Fuellstand;
import java.util.logging.Level;
import java.util.logging.Logger;
import network.Client;

/**
 *
 * @author Klaus
 */
public class FuellstandSimu extends Client {

  private static final String PREFIX = "Sender_";
  private static final String DIVIDER = "=";
  private static final int STREUUNG = 200;
  private static final int DELAY = 100;

  private double[] lztWerte = new double[10];

  public FuellstandSimu() {
    super("129.168.44.129", 25125);
    starteSignale();
  }

  private void starteSignale() {
    StringBuilder sb = new StringBuilder();
    double wert = 0;
    for (int j = 0; j < 100000; j++) {
      for (int i = 1; i <= 10; i++) {
        sb.append(PREFIX).append(i).append(DIVIDER);
        
        wert = Math.abs(Math.random() * (2 * STREUUNG) + lztWerte[i-1] - STREUUNG);
        sb.append(wert);
        lztWerte[i-1] = wert;

        this.send(sb.toString());
        sb.delete(0, sb.length());
        
        try {
          Thread.sleep(DELAY);
        } catch (InterruptedException ex) {
          Logger.getLogger(FuellstandSimu.class.getName()).log(Level.SEVERE, null, ex);
        }
      }
    }
  }

  @Override
  public void processMessage(String pMessage) {
    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  }

  public static void main(String[] args) {
    new Fuellstand();
    new FuellstandSimu();
  }

}
