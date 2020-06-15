package terceiroprojeto;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import javax.swing.*;

public class Plot extends JFrame {
    public Plot(ArrayList<Torre> torres_telefonicas) {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        PlotComponent pcomp = new PlotComponent(1000, 1000);
        add(pcomp);

        for (int i = 0; i < torres_telefonicas.size(); i++)
        {
            Torre torre = torres_telefonicas.get(i);
            
            pcomp.addTorre(torre.getCooredenada_x() * 1000, torre.getCooredenada_y() * 1000);

            Set<String> chaves = torre.dispositivos.keySet();
            
            for (String chave : chaves)
            {
                Dispositivo disp = torre.dispositivos.get(chave);
                
                pcomp.addDispositivo(disp.getCooredenada_x() * 1000, disp.getCooredenada_y() * 1000);
            }
        }

        pack();
        setVisible(true);
    }

    public static void show(ArrayList<Torre> torres_telefonicas)
    {
        SwingUtilities.invokeLater(()-> new Plot(torres_telefonicas));
    }
}

class PlotComponent extends JComponent {
    private ArrayList<Point2D> dispositivos = new ArrayList<Point2D>();
    private ArrayList<Point2D> torres = new ArrayList<Point2D>();

    public PlotComponent(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }

    public void addDispositivo(double x, double y) {
        dispositivos.add(new Point2D.Double(x, y));
    }
    
    public void addTorre(double x, double y) {
        torres.add(new Point2D.Double(x, y));
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setColor(Color.BLUE);

        for (Point2D p : dispositivos) {
            Shape point = new Ellipse2D.Double(p.getX(), p.getY(), 3, 3);
            g2d.draw(point);
        }
        
        g2d.setColor(Color.red);
        g2d.setPaintMode();
        for (Point2D p : torres) {
            Shape point = new Ellipse2D.Double(p.getX(), p.getY(), 5, 5);
            g2d.draw(point);
        }
    }
}