package Pro1;

import java.util.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;

  public class Panel extends JPanel{


//Hola A todos x 3


      public void paintComponent(Graphics p){

      super.paintComponent(p);
      int alto_plano = this.getHeight(); //alto
      int ancho_plano = this.getWidth(); //ancho

      p.drawLine(ancho_plano/2, 0, ancho_plano/2, alto_plano);
      p.drawLine(0, alto_plano/2, ancho_plano, alto_plano/2);

  }




}
