package app.panel;
import app.model.Snake;

import app.VentanaConfiguracion;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
// import app.model.Snake; <-- Lo añadiremos después

/**
 * Panel que contiene el bucle principal del juego, la serpiente y la comida.
 * Extiende JPanel para dibujar y usa ActionListener y KeyListener.
 */
public class GamePanel extends JPanel implements ActionListener, KeyListener {
    
    // 1. Variables de Estado y Configuración
    private boolean isRunning = false;
    private Snake snake;
    private final VentanaConfiguracion ventanaPrincipal; // Referencia a la ventana principal
    private Timer timer; // Controla la velocidad (el "tick" del juego)
    private final int TILE_SIZE = 20; // Tamaño de cada "cuadrado"
    
    // Constructor: Recibe la ventana principal
    public GamePanel(VentanaConfiguracion vp) {
        this.ventanaPrincipal = vp;
        // 2. Configuración Inicial del Panel
        setPreferredSize(new Dimension(800, 600)); 
        setBackground(Color.DARK_GRAY);
        setFocusable(true);
        addKeyListener(this);
        
        // Inicializa el Timer (Llamará a actionPerformed cada 150ms)
        this.snake = new Snake(10, 10, 3, Snake.Direction.RIGHT, TILE_SIZE); 
    
        this.timer = new Timer(150, this);
    }
    
    // Método para iniciar el bucle del juego (llamado desde el menú)
    public void startGameLoop() {
        isRunning = true;
        timer.start();
    }
    
    // --- MÉTODOS DE LAS INTERFACES (Obligatorios) ---
    
    // 1. ActionListener: Bucle de Actualización Lógica
    @Override
    public void actionPerformed(ActionEvent e){
        if(isRunning){
            // 1. Mover la serpiente (futuro: snake.move())
            // 2. Revisar colisiones (futuro: checkCollisions())
            snake.move();
            repaint(); // Llama a paintComponent() para redibujar
        }
        
    }
    
    // 2. Método de Dibujo: Renderiza la Serpiente y la Comida
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g); // <-- CORREGIDO: Llamada al método padre (Singular)
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.GREEN);
        
        for(Point segment : snake.getBody()){
            //Se multiplica la coordenada  por el tile size par aobjeter las coordenadas
            int x = segment.x * TILE_SIZE;
            int y = segment.y * TILE_SIZE;
            
            g2d.fillOval(x, y, TILE_SIZE, TILE_SIZE);
        }
        // Aquí se dibujará el tablero, la serpiente y la comida.
    }
    
    // 3. KeyListener: Captura de Entradas
    @Override
    public void keyPressed(KeyEvent e){
        // Aquí se cambiará la dirección de la serpiente
    }
    
    @Override
    public void keyTyped(KeyEvent e){
        // Se deja vacío.
    }
    
    @Override
    public void keyReleased(KeyEvent e){
        // Se deja vacío.
    }
}