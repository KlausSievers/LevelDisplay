package fuellstand;

import java.awt.Color;

/**
 *
 * @author Klaus
 */
public class Behaelter {
  private double max;
  private double warnung;
  private boolean voll;
  private Color farbe;
  private double fuellstand;

  public Behaelter(double max, double warnung, Color farbe) {
    this.max = max;
    this.warnung = warnung;
    this.farbe = farbe;
  }

  public void setFuellstand(double fuellstand) {
    this.fuellstand = fuellstand;
  }

  public double getMax() {
    return max;
  }

  public double getWarnung() {
    return warnung;
  }

  public Color getFarbe() {
    return farbe;
  }

  public boolean isVoll() {
    return voll;
  }

  public void setVoll(boolean voll) {
    this.voll = voll;
  }
   
  public double getFuellstand() {
    return fuellstand;
  }
  
  
  
  
}
