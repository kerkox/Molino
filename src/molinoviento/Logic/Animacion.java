/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package molinoviento.Logic;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import javax.swing.JComponent;
import javax.swing.Timer;

/**
 *
 * @author Paulker
 */
public class Animacion extends JComponent {

    private Aspa aspa1, aspa2, aspa3, aspa4;
    private int width;
    private int height;
    private int angulo = 90;
    private Timer timer = null;
    private int cx, cy;
    int clics = -1;
    int velocidad = 30;

    public Animacion(int width, int height) {
        this.width = width;
        this.height = height;
        this.cx = this.width / 2;
        this.cy = this.height / 2;
        if (aspa1 == null) {
            aspa1 = new Aspa(cx, cy, 350);
        }
        if (aspa2 == null) {
            aspa2 = new Aspa(cx, cy, 80);
        }
        if (aspa3 == null) {
            aspa3 = new Aspa(cx, cy, 170);
        }
        if (aspa4 == null) {
            aspa4 = new Aspa(cx, cy, 260);
        }
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {

        int x = width / 2, y = height / 2, a = 50;
        //dibujando cuerpo del molino
        g.setColor(Color.decode("#916a01"));
        int[] polx = {(x - (a / 2) - 40), x + (a / 2) + 40, x + (a / 2), x - (a / 2)};
        int[] poly = {y + (a / 2) + 160, y + (a / 2) + 160, y, y};
        g.drawPolygon(polx, poly, polx.length);
        g.fillPolygon(polx, poly, polx.length);

        //Centro Circula del Molino
        g.setColor(Color.GRAY);

        //Centro del molino
        g.drawOval((x - (a / 2)), (y - (a / 2)), a, a);
        g.fillOval((x - (a / 2)), (y - (a / 2)), a, a);

        //vartices de las aspas
        if (aspa1 != null) {
            g.setColor(Color.BLACK);
            g.drawLine((int) aspa1.getVertice().getStartX(),
                    (int) aspa1.getVertice().getStartY(),
                    (int) aspa1.getVertice().getEndX(),
                    (int) aspa1.getVertice().getEndY());
            g.setColor(Color.YELLOW);
            g.drawPolygon(aspa1.getPoligono());
            g.fillPolygon(aspa1.getPoligono());

        }

        if (aspa2 != null) {
            g.setColor(Color.BLACK);
            g.drawLine((int) aspa2.getVertice().getStartX(),
                    (int) aspa2.getVertice().getStartY(),
                    (int) aspa2.getVertice().getEndX(),
                    (int) aspa2.getVertice().getEndY());
            g.setColor(Color.YELLOW);
            g.drawPolygon(aspa2.getPoligono());
            g.fillPolygon(aspa2.getPoligono());

        }
        if (aspa3 != null) {
            g.setColor(Color.BLACK);
            g.drawLine((int) aspa3.getVertice().getStartX(),
                    (int) aspa3.getVertice().getStartY(),
                    (int) aspa3.getVertice().getEndX(),
                    (int) aspa3.getVertice().getEndY());
            g.setColor(Color.YELLOW);
            g.drawPolygon(aspa3.getPoligono());
            g.fillPolygon(aspa3.getPoligono());
        }
        if (aspa4 != null) {
            g.setColor(Color.BLACK);
            g.drawLine((int) aspa4.getVertice().getStartX(),
                    (int) aspa4.getVertice().getStartY(),
                    (int) aspa4.getVertice().getEndX(),
                    (int) aspa4.getVertice().getEndY());
            g.setColor(Color.YELLOW);
            g.drawPolygon(aspa4.getPoligono());
            g.fillPolygon(aspa4.getPoligono());
        }
    }

    public void init() {

        if (aspa1 == null) {
            aspa1 = new Aspa(cx, cy, 350);
        }
        if (aspa2 == null) {
            aspa2 = new Aspa(cx, cy, 80);
        }
        if (aspa3 == null) {
            aspa3 = new Aspa(cx, cy, 170);
        }
        if (aspa4 == null) {
            aspa4 = new Aspa(cx, cy, 260);
        }

        if (timer == null) {
            timer = new Timer(velocidad, (ActionEvent e) -> {
                int giro = 1;
                angulo += giro;

                aspa1.girar(cx, cy, giro);
                aspa2.girar(cx, cy, giro);
                aspa3.girar(cx, cy, giro);
                aspa4.girar(cx, cy, giro);
                repaint();
            });
        }
        timer.start();

    }

    public void pause() {
        this.timer.stop();
        this.timer = null;
//        repaint();
    }

    public void acelerar() {

        if (timer == null) {
            init();
            clics = 0;
        } else {

            switch (clics) {
                case 0:
                    velocidad = 10;
                    pause();
                    init();

                    break;
                case 1:
                    velocidad = 2;
                    pause();
                    init();

                    break;
                case 2:
                    velocidad = 30;
                    clics = -1;
                    pause();

                    break;

            }

            clics++;

        }

    }

}
