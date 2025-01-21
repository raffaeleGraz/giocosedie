/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giocosedie;

import java.util.Scanner;
import java.util.logging.Logger;

/**
 *
 * @author MC
 */
public class TestGiocoSedie {
    private static Logger logger = Logger.getLogger("GiocoSedie.TestGiocoSedie");
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Numero Giocatori: ");
        int partecipanti = scanner.nextInt();
        
        Posto sedie[] = new Posto[partecipanti - 1];

	for (int k = 0; k < sedie.length; k++)
            sedie[k] = new Posto();

	Display display = new Display(sedie);
	//System.out.println("Sto facendo partire il Display.");
        logger.info("Sto facendo partire il Display.\n");
	display.start();

	Partecipante array[] = new Partecipante[partecipanti];
        System.out.println("GIOCATORI:" + array.length);
	for (int i = 0; i < partecipanti; i++) {
            array[i] = new Partecipante(sedie);
            //System.out.println("Sto facendo partire il thread n." + array[i].getId());
            logger.info("Sto facendo partire il thread id: " + array[i].getId()+" name: "+array[i].getName()+"\n");
            array[i].start();
        }
        
    }
}
