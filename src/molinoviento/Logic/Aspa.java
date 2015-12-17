/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molinoviento.Logic;

import java.awt.Polygon;
import javafx.scene.shape.Line;

/**
 *
 * @author Paulker
 */
public class Aspa {

    private int[] CoorX;
    private int[] CoorY;
    private Line vertice;
    double[] distancias = null;
    private Polygon poligono;
    private int Angulo;

    public Aspa(int cx, int cy, int angulo) {
        Angulo = angulo;
        
        double distancia = 130;
        int separacion = 20;

        int[] corX = {cx + (int) ((distancia - 90) * Math.cos(Math.toRadians(Angulo))),
            cx + (int) ((distancia - 90) * Math.cos(Math.toRadians(Angulo + separacion))),
            cx + (int) (distancia * Math.cos(Math.toRadians(Angulo + separacion))),
            cx + (int) (distancia * Math.cos(Math.toRadians(Angulo)))};
        int[] corY = {cy - (int) ((distancia - 90) * Math.sin(Math.toRadians(Angulo))),
            cy - (int) ((distancia - 90) * Math.sin(Math.toRadians(Angulo + separacion))),
            cy - (int) (distancia * Math.sin(Math.toRadians(Angulo + separacion))),
            cy - (int) (distancia * Math.sin(Math.toRadians(Angulo)))};

        this.CoorX = corX;
        this.CoorY = corY;
        this.poligono = new Polygon(this.CoorX, this.CoorY, this.CoorX.length);
        //========================================
        //El vertice que sostiene el aspa
        int x, y;
        int radio = 50;
        x = (int)(radio *Math.cos(Math.toRadians(Angulo+10)));
        y = (int)(radio *Math.sin(Math.toRadians(Angulo+10)));
        vertice = new Line(cx+x,cy-y, cx, cy);
        
    }

    public int[] getCoorX() {
        return CoorX;
    }

    public void setCoorX(int[] CoorX) {
        this.CoorX = CoorX;
    }

    public int[] getCoorY() {
        return CoorY;
    }

    public void setCoorY(int[] CoorY) {
        this.CoorY = CoorY;
    }

    public Polygon getPoligono() {
        return poligono;
    }

    public void setPoligono(Polygon poligono) {
        this.poligono = poligono;
    }

    public void girar(int cx, int cy, int grados) {
        Angulo += grados;
        double distancia = 130;
        int separacion = 20;
        int[] corX = {cx + (int) ((distancia - 90) * Math.cos(Math.toRadians(Angulo))),
            cx + (int) ((distancia - 90) * Math.cos(Math.toRadians(Angulo + separacion))),
            cx + (int) (distancia * Math.cos(Math.toRadians(Angulo + separacion))),
            cx + (int) (distancia * Math.cos(Math.toRadians(Angulo)))};
        int[] corY = {cy - (int) ((distancia - 90) * Math.sin(Math.toRadians(Angulo))),
            cy - (int) ((distancia - 90) * Math.sin(Math.toRadians(Angulo + separacion))),
            cy - (int) (distancia * Math.sin(Math.toRadians(Angulo + separacion))),
            cy - (int) (distancia * Math.sin(Math.toRadians(Angulo)))};

        this.CoorX = corX;
        this.CoorY = corY;
        this.poligono = new Polygon(this.CoorX, this.CoorY, this.CoorX.length);
        //========================================
        //El vertice que sostiene el aspa
        int x, y;
        int radio = 50;
        x = (int)(radio *Math.cos(Math.toRadians(Angulo+10)));
        y = (int)(radio *Math.sin(Math.toRadians(Angulo+10)));
        vertice = new Line(cx+x,cy-y, cx, cy);

    }
    
    public Line getVertice(){
        return this.vertice;
    }

}
