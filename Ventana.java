package Pro1;

import java.util.*;
import java.awt.*;
import java.lang.*;
import java.awt.event.*;
import javax.swing.*;

public class Ventana extends JFrame{
  int x,y;
  int canC,cant, k;
  GPuntos generacion;
  Panel panel1;
  JLabel clases, limite, labelk;
  JTextField jTextc, jTextk, jTextt;
  JButton ok ;

  //constructor


  public Ventana(){

      setSize(1000,700);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setTitle("Ventana ");
      setLocationRelativeTo(null);
      setLayout(null);
      initComponents();
      setVisible(true);
      repaint();
      generaclases();

  }

  public void  initComponents(){


      panel1 = new Panel();
      panel1.setLayout(null);


      clases = new JLabel("clases");
      limite = new JLabel("limite");
      labelk = new JLabel("K");

      ok= new JButton("Cerrar ");
      //ok2= new JButton("Limpiar ");


      jTextc= new JTextField("5");
      jTextk= new JTextField("6");
      jTextt= new JTextField("4");


      panel1.setBounds(10,10,600,500);
      clases.setBounds(800,100,120,30);
      limite.setBounds(800,300,120,30);
  		labelk.setBounds(800,200,120,30);
  		ok.setBounds(800,500,120,30);
  		//ok2.setBounds(800,400,120,30);
  		jTextc.setBounds(800,150,120,30);
  		jTextk.setBounds(800,250,120,30);
      jTextt.setBounds(800,350,120,30);
      panel1.setBackground(new Color(808180));
  		add(clases);
  		add(limite);
  		add(labelk);
  		add(ok);
  		//add(ok2);
  		add(jTextc);
  		add(jTextk);
      add(jTextt);
      add(panel1);

      panel1.addMouseListener(new MouseAdapter(){
        public void mouseClicked(MouseEvent evt){
            formMouseClicked(evt);

        }

      });

      ok.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
          System.exit(0);
        }
      });

  }

  public void formMouseClicked(MouseEvent evt){
    x=evt.getX();
    y=evt.getY();
    generacion.px = x;
    generacion.py = y;
    generacion.calculaDistancia();
    generacion.imprimirDistancias();
    generacion.ordena();
    generacion.imprimirDistancias();
    JOptionPane.showMessageDialog(this, "la clase es: " + generacion.seleccionada);
    puntos(panel1.getGraphics());

  }
  public void puntos(Graphics p){

      p.setColor(Color.RED);
      p.fillOval(x,y,5,5);

}
  public void generaclases(){
    canC= Integer.parseInt(jTextc.getText());
    cant= Integer.parseInt(jTextt.getText());
    k= Integer.parseInt(jTextk.getText());
    System.out.println(k);
    generacion = new GPuntos(canC, cant,  k, panel1.getWidth(), panel1.getHeight());
    generacion.gen();
    generacion.imprimir();
    System.out.println ("Antes");
    pindatos(panel1.getGraphics());
    System.out.println("Terminado");
    generacion.calculaDistancia();
  }


  public void pindatos(Graphics p){
      System.out.println("Entrando ala funcion ");

    for (int j=0;j<generacion.arreglo.size();j++ ){
      System.out.println("Pintando");
    p.setColor(Color.WHITE);
    p.fillOval(generacion.arreglo.get(j).x,generacion.arreglo.get(j).y,5,5);

    }

  }

  public static void main(String[] args) {

    Ventana sc = new Ventana();
  }

  public void update(Graphics p){
    super.update(p);

  }

} //erencia
