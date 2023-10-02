
import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.BOLD;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author Rodolfo Javier Meneses Leal
 */

// Esta clase se encarga de animar el movimiento del texto sobre el banner.
public class Text_Animation extends JPanel{
        
        int position_x = getWidth();  // Posicion del texto sobre eje X Position where the text will be draw over X axis (Horizontally)
        int position_y;               // Posicion del texto sobre eje Y Position where the text will be draw over Y axis (Vertically)
        
        String text;                  // Texto a mostrar con animacion 
        int stringLenghtPixels;       // Cantidad de carracteres en el string 
        
        Text_Animation(String text, int y){ // Constructor con parametros de texto que viene desde la base de datos
            this.text = text;
            this.stringLenghtPixels = text.length() * 7; 
            this.position_y = y / 2; // Para ubicar el texto en el puro centro DEL BANNER
        }
        
            @Override
        public void paint(Graphics gp){
            
            // Funcion que dibujara el texto en pantalla
            super.paint(gp);            
            Graphics2D graphic = (Graphics2D) gp;
            graphic.setColor(Color.BLACK);  // Color de la letra 
            graphic.setFont(new Font("NORMAL", BOLD, 13)); // Tamaño y fuente 
            graphic.drawString(text, position_x, position_y); // Posicion y texto a dibujar en pantalla

            try{
                // Con uso de thread moverla el texto 1 pixel cada 9 milisegundos 
                Thread.sleep(9);
                position_x -= 1;
                
                // Si la posicion del texto ya recorrio todo el banner, entonces reinicia su posicion
                // para que vuelta a mostrarse en pantalla.
                if(position_x < -this.stringLenghtPixels){
                    position_x = getWidth();
                }
                
                //Imporante redibujar, sin este metodo el texto no se mueve.
                repaint();
            } 
            catch(InterruptedException ex){
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }