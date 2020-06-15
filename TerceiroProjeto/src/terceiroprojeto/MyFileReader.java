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
import java.io.*;

public class MyFileReader{

    private BufferedReader bufferedReader;
    
    public MyFileReader(String filename)
    {
        FileReader fileReader = null;
        try
        {
            fileReader = new FileReader(filename);
            bufferedReader = new BufferedReader(fileReader);
        }
        catch (FileNotFoundException e)
        {
            System.err.println("Input file not found: " + filename);
            //e.printStackTrace();
        }
    }
    
    public String readLine()
    {
        try
        {
            if (bufferedReader != null)
            {
                return bufferedReader.readLine();
            }
        }
        catch (IOException e)
        {
            System.err.println("Error reading file");
            //e.printStackTrace();
        }
        return null;
    }
    
    public void close()
    {
        try
        {
            if (bufferedReader != null)
            {
                bufferedReader.close();
            }
        }
        catch(IOException e)
        {
            System.err.println("Error closing file");
            //e.printStackTrace();
        }
        bufferedReader = null;
    }
}