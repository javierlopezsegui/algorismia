/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloom;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author javier.lopez.segui
 */
public class main { 
    public static Integer m;
    public static Integer k; 
    public static Integer dataSize;
    public static ArrayList<Boolean> filter = new ArrayList<Boolean>();
    public static Scanner input = new Scanner(System.in);
    
    
    public static void main(String[] args) {
        
        System.out.println("Number of data pieces?");
        dataSize = input.nextInt();
        System.out.println("Value of k?");
        k = input.nextInt();
        System.out.println("Value of m?");
        m = input.nextInt();
        for (int i = 0; i < m; ++i){
            filter.add(i,false);
        }
        main mn = new main();
        mn.start();
        
    }
    
    public void start(){
        ReadData();
        System.out.println("1- Check data\n2- Add data\n3- Terminate program\n");
        Integer aux = input.nextInt();
        while (aux != 3){
            if (aux == 1){
                System.out.println("Input data to check");
                String aux2 = input.next();
                checkData(aux2);
            }
            else if (aux == 2){
                System.out.println("Input new data");
                String aux2 = input.next();
                add(aux2);
                ++dataSize;
            }
            else System.out.println("Please select a valid option");
            System.out.println("1- Check data\n2- Add data\n3- Terminate program");
            aux = input.nextInt();
        }
    }
    
    private void ReadData() {        
        try {
            // Lee el archivo de datos y rellena el filtro haciendo adds
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            for (int i = 0; i< dataSize; ++i){
                add(br.readLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("The file is not reachable/incorrectly named");
        } catch (IOException ex) {
            System.out.println("I/O exception ocurred");
        } 
    }
    
    private void add(String d){ // genera un valor del para cada dato segun hash(i), pone ese indice del filtro a true
        for (int i = 0; i < k; ++i){
            filter.set(hashFunction(i, d), true);
        }
    }
    
    private void checkData(String d){
        Boolean nomatch = false;
        for (int i = 0; i < k; ++i){
            if (! filter.get(hashFunction(i,d))){
                System.out.println("This data IS NOT in the set");
                nomatch = true;
            } 
            System.out.println(nomatch);
            if (nomatch) break;
        }
        if (! nomatch) System.out.println("This data IS POSSIBLY in the set");
    }
    
    private Integer hashFunction(int variation, String value){
        
        // ESTO ES LO UNICO QUE HAY QUE TERMINAR PARA TENER EL PUNTO 1 HECHO
        return 1;  //hay que rellenar la hashfunction
    }
    
    
}
