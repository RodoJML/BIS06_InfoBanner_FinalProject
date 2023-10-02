
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import static java.lang.Math.round;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import javax.swing.JPanel;

/**
 * @author Rodolfo Meneses Leal
 */
public class View implements ActionListener{
    
    // No se instancia objeto pero se hace referencia a la clase Modelo.
    Model banner;
    
    // Se declara un objeto JFrame que contendra todos los elementos visuales.
    JFrame mainBar;
    
    // Constructor que hace referencia al modelo para luego poder acceder a sus metodos.
    View(Model parameter0){
        this.banner = parameter0;
    }
            
    // Metodo que solicita en pantalla la ruta de la base de datos, returna el input en modo String
    String dbPathRequest(){
        String userInput = JOptionPane.showInputDialog(null, "Por favor indicar la ruta de su base de datos "
                                                        + "\nFormato Local ejemplo: /Users/rodo/sqlite/db/bannerData.db"
                                                        + "\nFormato Web ejemplo: http://host/puerto/ruta archivo", "Base de Datos", WARNING_MESSAGE);
        return userInput;
    }
    
    
    @SuppressWarnings("unchecked")
    
    // Metodo que ejecuta el banner principal
    // String[] lineOfBis: Es la lista de linea de negocios en la BD para desplegarlas en un JCOmboBox
    // String news: es una sola linea de caracteres con todas las noticias a desplegar en el banner
    // String selectedLOB: Este es solo 1 String con el nombre de la linea seleccionada por el usuario, para mostara en pantalla la seleccion actual.
    // String[] metrics: Es un array que solo tiene 2 indices, [0] Un solo string de metricas de QA [1] Un solo string de metricas operacionales
    void notificationBar (String[] lineOfBis, String news, String selectedLOB, String[] metrics){
        
        
        // Estos son los mensajes que apareceran por defecto en el banner
        // Cuando el banner este en modo default osea antes de que el usuario haga la seleccion
        // de alguna linea de negocio. 
        String defaultNewsMessage   = "Maintain Avalon's Strategic partner of choice position by exceeding "
                                    + "defined account's business objectives and making inroads into new "
                                    + "high value businesses. This vision can be achieved by living our culture"
                                    + "and 3V operating philosophy. "
                                    + "If there are no LOB options available to select the database is empty";
        String detaultLOBinfo       = "Please select your LOB";
        String defaultMetrics1      = "Velocity, Visbility and Value";
        String defaultMetrics2      = "Our goal is to be within the top 3 vendors, always above Enterprise";
        String information2 = "";
        String information3 = "";
        String information1 = news;
        String information4 = selectedLOB;
        
        // Si la informacion de las metricas en el parametro es diferente a nulo
        // entonces muestra la información proveniete del parametro y la asignamos a las variables string.
        if(metrics != null){
            information2 = metrics[0];
            information3 = metrics[1];
        }
        
        
        // Si no hay un LOB selccionado, todos los mensajes mostrados seran los default
        if(selectedLOB == ""){
            information1 = defaultNewsMessage;
            information2 = defaultMetrics1;
            information3 = defaultMetrics2;
            information4 = detaultLOBinfo;
        }
        
        
        // Con esta variable obtenemos el tamaño actual de la pantalla 
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        
        // Obtenemos el tamaño de la pantalla en su alto y ancho
        int screen_X = screenSize.width;
        int screen_Y = screenSize.height;
        
        // Marco principal del banner y sus caracteristicas
        int mainBarbarSize_X = screen_X;                    // Tamaño sobre eje X
        int mainBarbarSize_Y = (int)(screen_Y * 0.024);     // Tamaño sobre eje Y
        this.mainBar = new JFrame("Avalon Notifications");  // Creacion Frame principal, instanciado como atributo de clase.
        this.mainBar.setSize(mainBarbarSize_X, mainBarbarSize_Y);
        this.mainBar.setUndecorated(true);                  // Para que no muestre la barra de cerrar y minimizar. 
        this.mainBar.setLocation(0,0);                      // Ubicacion en pantalla
        
        // Este sera un contenedor de elementos graficos, que luego se pondra sobre el marco principal
        JPanel container0 = new JPanel();
        
        // Se crea el selector de LOB
        JLabel lobLabel = new JLabel(" LOB: " + information4);
        lobLabel.setForeground(Color.BLUE);
        
        // Menu para seleccionar el LOB observe que usa el parametro proporcionado al inicio de la funcion
        JComboBox lOBSelector = new JComboBox(lineOfBis);
        lOBSelector.setPreferredSize(new Dimension(40,50));
        lOBSelector.addActionListener(this);  
        
        // Panel A (Ajustes y contenido) --------------------------------------
        // Creacion del objeto Text_Animation que hereda de JPanel por lo que se trata como tal, su altura deberia ser la misma que la del banner principal.
        Text_Animation panel_A = new Text_Animation(information1, mainBarbarSize_Y);            
        
        int a_panelSize_X = (int) round(mainBarbarSize_X * 0.62); // Aqui indicamos que el Panel_A ocupara siempre el 62% del banner
        int a_panelSize_Y = mainBarbarSize_Y - 10;  
        
        panel_A.setPreferredSize(new Dimension(a_panelSize_X, a_panelSize_Y));
        panel_A.setVisible(true);
        

        // Panel B (Ajustes y contenido) --------------------------------------
        Text_Animation panel_B = new Text_Animation(information2, mainBarbarSize_Y);
        
        int b_panelSize_X = (int) round(mainBarbarSize_X * 0.125);
        int b_panelSize_Y = mainBarbarSize_Y - 10;
        
        panel_B.setPreferredSize(new Dimension(b_panelSize_X, b_panelSize_Y));
        panel_B.setBackground(Color.ORANGE);
        panel_B.setVisible(true);
        
        
        // Panel C (Ajustes y contenido) --------------------------------------
        Text_Animation panel_C = new Text_Animation(information3, mainBarbarSize_Y);
        
        int c_panelSize_X = (int) round(mainBarbarSize_X * 0.125);
        int c_panelSize_Y = mainBarbarSize_Y - 10;
        
        panel_C.setPreferredSize(new Dimension(c_panelSize_X, c_panelSize_Y));
        panel_C.setBackground(Color.ORANGE);
        panel_C.setVisible(true);
        
        container0.add(panel_A);
        container0.add(panel_B);
        container0.add(panel_C);

        
        // Una vez tenemos todos los elementos graficos en los contenedores
        // agregamos los contenedores al marco principal 
        this.mainBar.add(container0, BorderLayout.LINE_END);
        this.mainBar.add(lOBSelector, BorderLayout.LINE_START);
        this.mainBar.add(lobLabel, BorderLayout.CENTER);
        
        this.mainBar.repaint();
        this.mainBar.setVisible(true);
        this.mainBar.setAlwaysOnTop(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        // Lee la seleccion del JCombo Box
        JComboBox cb = (JComboBox)e.getSource();
        String selectedLOB = (String)cb.getSelectedItem();
        
        try {
            // Cuando se cambia de seleccion en el JCombo Box entonces se cierra el bannery se vuelve a cargar
            cb.setSelectedItem(selectedLOB);
            // Esta vez se carga el banner con toda la informacion de la linea seleccionada por el usuario
            mainBar.dispatchEvent(new WindowEvent(mainBar, WindowEvent.WINDOW_CLOSING));
            notificationBar(banner.getLOBs(), banner.getNews(selectedLOB), selectedLOB, banner.getMetrics(selectedLOB));
            
        } catch (SQLException ex) {
            Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

