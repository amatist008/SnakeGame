package app.panel;

import app.VentanaConfiguracion;
import java.awt.GridBagLayout;
import java.awt.*;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
public class MenuSnake extends JPanel{
    private VentanaConfiguracion ventanaPrincipal;

    public MenuSnake(VentanaConfiguracion vp) {
        this.ventanaPrincipal = vp;
        
        setLayout(new GridBagLayout());
        setBackground(Color.BLACK);
        
        JLabel logo_label = new JLabel("LOGO DEL JUEGO", SwingConstants.CENTER);
        logo_label.setFont(new Font("Arial", Font.BOLD, 40));
        logo_label.setForeground(Color.GREEN);
        
        //Cargar la imagen
        
        try {
            URL imageUrl = getClass().getResource("/sources/snake_Logo.jpeg");
            
            if (imageUrl != null){
                ImageIcon icon = new ImageIcon(imageUrl);
                logo_label.setIcon(icon);
                logo_label.setText("");
            }else{
                System.out.println("Error: No se encontró el recurso en /app/resources/snake_Logo.jpeg");
            }
        }catch (Exception e){
            System.out.println("No se pudo cargar el logo por un error de lectura. Usando texto.");
            e.printStackTrace();
        }
        
        JButton iniciarBtn = createButton("Iniciar Juego");
        JButton configBtn = createButton("Configuración");
        
        iniciarBtn.addActionListener(e -> ventanaPrincipal.mostrarPanelJuego());
        configBtn.addActionListener(e -> ventanaPrincipal.showConfig());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 10, 15, 10);
        gbc.gridx = 0;
        
        gbc.gridy = 0;
        gbc.weighty = 0.8;
        add(logo_label, gbc);
        
        gbc.gridy = 1; gbc.weighty = 0.1; 
        add(iniciarBtn, gbc); // Agrega el botón Iniciar
        
        gbc.gridy = 2; gbc.weighty = 0.1;
        add(configBtn, gbc); // Agrega el botón Configuración
        
        
    }
    private JButton createButton(String text){
            JButton btn = new JButton(text);
            btn.setPreferredSize(new Dimension(250, 50));
            btn.setFont(new Font("Arial", Font.PLAIN, 20));
            btn.setBackground(Color.GREEN.darker().darker());
            btn.setForeground(Color.WHITE);
            btn.setFocusPainted(false);
            return btn;
        }
    
    
}
