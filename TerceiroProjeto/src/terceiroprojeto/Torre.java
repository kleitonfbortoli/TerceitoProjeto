/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terceiroprojeto;

import java.util.HashMap;
import java.util.TreeMap;

/**
 *
 * @author kleiton_bortoli
 */
public class Torre
{
    double cooredenada_x;
    double cooredenada_y;
    TreeMap<String,Dispositivo> dispositivos;
    
    public Torre(double coordenada_x, double coordenada_y)
    {
        this.cooredenada_x = coordenada_x;
        this.cooredenada_y = coordenada_y;
        this.dispositivos = new TreeMap<String,Dispositivo>();
    }

    public double getCooredenada_x() {
        return cooredenada_x;
    }

    public void setCooredenada_x(double cooredenada_x)
    {
        this.cooredenada_x = cooredenada_x;
    }

    public double getCooredenada_y()
    {
        return cooredenada_y;
    }

    public void setCooredenada_y(double cooredenada_y)
    {
        this.cooredenada_y = cooredenada_y;
    }

    public TreeMap<String,Dispositivo> getDispositivos()
    {
        return dispositivos;
    }

    public void addDispositivos(String chave, Dispositivo dispositivo)
    {
        this.dispositivos.put(chave, dispositivo);
    }
    
    public double calculaDistancia(double ponto_x, double ponto_y)
    {
        double result;
        result = (ponto_x - this.cooredenada_x) + (ponto_y - this.cooredenada_y);
        
        if(result < 0)
        {
            result = result * -1;
        }
        
        return result;
    }
}
