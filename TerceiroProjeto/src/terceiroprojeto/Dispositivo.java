/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terceiroprojeto;

/**
 *
 * @author kleiton_bortoli
 */
public class Dispositivo
{
    String name;
    double cooredenada_x;
    double cooredenada_y;
    double distancia;
    
    public Dispositivo(String name, double coordenada_x, double coordenada_y)
    {
        this.name = name;
        this.cooredenada_x = coordenada_x;
        this.cooredenada_y = coordenada_y;
    }

    public double getCooredenada_x() {
        return cooredenada_x;
    }

    public void setCooredenada_x(double cooredenada_x) {
        this.cooredenada_x = cooredenada_x;
    }

    public double getCooredenada_y() {
        return cooredenada_y;
    }

    public void setCooredenada_y(double cooredenada_y) {
        this.cooredenada_y = cooredenada_y;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    

}
