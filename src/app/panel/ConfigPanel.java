/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.panel;

import app.VentanaConfiguracion;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 *
 * @author sofi
 */
public class ConfigPanel  extends JPanel{
    private VentanaConfiguracion ventanaPrincipal;

    public ConfigPanel(VentanaConfiguracion vp) {
        this.ventanaPrincipal = vp;
        
        setLayout(new BorderLayout());
        
        add(new JLabel ("AQUI VA LA CONFIGURACION", SwingConstants.CENTER), BorderLayout.CENTER);
        
        JButton backBtn = new JButton("Volver al Menú");
        backBtn.addActionListener(e -> ventanaPrincipal.showMenu());
        
        JPanel southPanel = new JPanel();
        southPanel.add(backBtn);
        add(southPanel, BorderLayout.SOUTH);
        
    }
    
    
}
