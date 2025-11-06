package app.model;

import java.awt.Color;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author sofi
 */
public class SnakeSkin {
    private int id;
    private Color bodyColor;
    private Color headColor;
    
    public SnakeSkin(int id, String name, Color bodyColor, Color headColor){
        this.id = id;
        this.bodyColor = bodyColor;
        this.headColor = headColor;
    }

    public Color getBodyColor() {
        return bodyColor;
    }

    public Color getHeadColor() {
        return headColor;
    }
    
    public static SnakeSkin getSkinById(int id){
        switch (id){
            case 1: 
                return new SnakeSkin(1, "Clasico", new Color(0,150,0), new Color(0,100,0));
            case 2:
                return new SnakeSkin(2, "Cobra Azul", Color.BLUE, Color.BLUE.darker());
            default:
                return getSkinById(1);
        }
    }
    
}
