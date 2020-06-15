/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terceiroprojeto;

import java.util.ArrayList;
import java.util.Set;

/**
 *
 * @author kleiton_bortoli
 */
public class TerceiroProjeto {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ArrayList<Torre> torres_telefonicas = new ArrayList();
        
        //adiciona as 16 torres
        torres_telefonicas.add(new Torre(0.1,0.1));
        torres_telefonicas.add(new Torre(0.1,0.3));
        torres_telefonicas.add(new Torre(0.1,0.7));
        torres_telefonicas.add(new Torre(0.1,0.9));
        torres_telefonicas.add(new Torre(0.3,0.1));
        torres_telefonicas.add(new Torre(0.3,0.3));
        torres_telefonicas.add(new Torre(0.3,0.7));
        torres_telefonicas.add(new Torre(0.3,0.9));
        torres_telefonicas.add(new Torre(0.7,0.1));
        torres_telefonicas.add(new Torre(0.7,0.3));
        torres_telefonicas.add(new Torre(0.7,0.7));
        torres_telefonicas.add(new Torre(0.7,0.9));
        torres_telefonicas.add(new Torre(0.9,0.1));
        torres_telefonicas.add(new Torre(0.9,0.3));
        torres_telefonicas.add(new Torre(0.9,0.7));
        torres_telefonicas.add(new Torre(0.9,0.9));
        
        MyFileReader file = new MyFileReader("/home/kleiton_bortoli/mobile.txt");
        
        String str;
        str = file.readLine();
        str = file.readLine();
        
        while (str != null)
        {
            String[] dados = str.split("[;]");
            Dispositivo dipositivo = new Dispositivo(dados[0], Double.parseDouble(dados[1]), Double.parseDouble(dados[2]));
            
            int id_torre_menor_distancia = -1;
            double menor_distancia = -1;

            for (int a = 0; a < torres_telefonicas.size(); a++)
            {
                Torre torre = torres_telefonicas.get(a);

                // sempre retorna distancia positiva
                double distancia = torre.calculaDistancia(dipositivo.getCooredenada_x(), dipositivo.getCooredenada_y());
                
                if(menor_distancia > distancia || menor_distancia == -1.0)
                {
                    menor_distancia = distancia;
                    id_torre_menor_distancia = a;
                }
            }
            
            Torre torre = torres_telefonicas.get(id_torre_menor_distancia);

            dipositivo.setDistancia(menor_distancia);
            
            torre.addDispositivos(dados[0], dipositivo);

            torres_telefonicas.set(id_torre_menor_distancia, torre);
            
            str = file.readLine();
        }

        System.out.println("Torres");
        for (int i = 0; i < torres_telefonicas.size(); i++)
        {
             Torre torre = torres_telefonicas.get(i);
             
            System.out.println("Torre " + i);

            System.out.println("Dispositivo | Distancia");
            
            Set<String> chaves = torre.dispositivos.keySet();
            
            for (String chave : chaves)
            {
                double distancia = torre.dispositivos.get(chave).getDistancia();
                
                System.out.println(chave + " | " + distancia);
            }
        }
        Plot.show(torres_telefonicas);
    }
}
