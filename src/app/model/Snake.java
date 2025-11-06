/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package app.model;

import java.util.List; 
import java.awt.Point;
import java.util.LinkedList;

/**
 *
 * @author sofi
 */
public class Snake {
    public enum Direction{
        UP, DOWN, LEFT, RIGHT
    }
    
    private List<Point> body;
    private Direction direction;
    private final int TILE_SIZE;

    public Snake(int initialX, int initialY, int initialLength, Direction initialDirection, int tileSize) {
       body = new LinkedList<>();
       this.TILE_SIZE = tileSize;
       this.direction = initialDirection;
       
       for (int i = 0; i < initialLength; i++){
           body.add(new Point(initialX - i , initialY));
       }
    }
    
    public void move(){
        //1. Obtener la posicion de la cabeza actual
        
        Point head = body.get(0);
        
        //2. Calcular la nueva posicion de la cabeza
        
        Point newHead = new Point(head);
        
        switch (direction){
            case UP:
                newHead.y--;
            case DOWN:
                newHead.y++;
            case LEFT:
                newHead.x--;
            case RIGHT:
                newHead.x++;
                    
        }
        //Añadir la nueva cabeza al inicio de la lista
        body.add(0, newHead);
        body.remove(body.size() - 1);
    }
    
    
    //Irá la lógica de movimiento, crecimiento y de colisión

    public List<Point> getBody() {
        return body;
    }
    
    public Point getHead() {
        return body.get(0);
    }

    public Direction getDirection() {
        return direction;
    }
    
    public void setDirection(Direction newDirection) {
        // Evita que la serpiente se mueva 180 grados de golpe
        if (direction == Direction.UP && newDirection == Direction.DOWN) return;
        if (direction == Direction.DOWN && newDirection == Direction.UP) return;
        if (direction == Direction.LEFT && newDirection == Direction.RIGHT) return;
        if (direction == Direction.RIGHT && newDirection == Direction.LEFT) return;
        
        this.direction = newDirection;
    }
}

