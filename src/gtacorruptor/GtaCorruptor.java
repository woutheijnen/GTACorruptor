/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gtacorruptor;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Wout
 */
public class GtaCorruptor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       ArrayList<File> filesToCopy = new ArrayList<>();
       ArrayList<File> filesToSave = new ArrayList<>();
       filesToCopy.add(new File("handling.dat"));
       filesToSave.add(new File("C:\\Games\\Grand Theft Auto IV - The Complete Edition\\Grand Theft Auto IV\\common\\data\\handling.dat"));
       
       /*filesToCopy.add(new File("WeaponInfo - Copy.xml"));
       filesToSave.add(new File("D:\\Program Files (x86)\\Mr DJ\\Grand Theft Auto IV\\common\\data\\WeaponInfo.xml"));
       filesToCopy.add(new File("pedpersonality - Copy.dat"));
       filesToSave.add(new File("D:\\Program Files (x86)\\Mr DJ\\Grand Theft Auto IV\\common\\data\\pedpersonality.dat"));
       filesToCopy.add(new File("action_table - Copy.csv"));
       filesToSave.add(new File("D:\\Program Files (x86)\\Mr DJ\\Grand Theft Auto IV\\common\\data\\action_table.csv"));
       filesToCopy.add(new File("vehOff - Copy.csv"));
       filesToSave.add(new File("D:\\Program Files (x86)\\Mr DJ\\Grand Theft Auto IV\\common\\data\\vehOff.csv"));
       filesToCopy.add(new File("info - Copy.zon"));
       filesToSave.add(new File("D:\\Program Files (x86)\\Mr DJ\\Grand Theft Auto IV\\common\\data\\info.zon"));
       filesToCopy.add(new File("object - Copy.dat"));
       filesToSave.add(new File("D:\\Program Files (x86)\\Mr DJ\\Grand Theft Auto IV\\common\\data\\object.dat"));
       filesToCopy.add(new File("plants - Copy.dat"));
       filesToSave.add(new File("D:\\Program Files (x86)\\Mr DJ\\Grand Theft Auto IV\\common\\data\\plants.dat"));
       filesToCopy.add(new File("popcycle - Copy.dat"));
       filesToSave.add(new File("D:\\Program Files (x86)\\Mr DJ\\Grand Theft Auto IV\\common\\data\\popcycle.dat"));
       filesToCopy.add(new File("popcycle - Copy.datnew"));
       filesToSave.add(new File("D:\\Program Files (x86)\\Mr DJ\\Grand Theft Auto IV\\common\\data\\popcycle.datnew"));
       filesToCopy.add(new File("Scenarios - Copy.dat"));
       filesToSave.add(new File("D:\\Program Files (x86)\\Mr DJ\\Grand Theft Auto IV\\common\\data\\Scenarios.dat"));*/
       
       /*filesToCopy.add(new File("ShockingEvents - Copy.dat"));
       filesToSave.add(new File("D:\\Program Files (x86)\\Mr DJ\\Grand Theft Auto IV\\common\\data\\ShockingEvents.dat"));
       filesToCopy.add(new File("ThrownWeaponInfo - Copy.xml"));
       filesToSave.add(new File("D:\\Program Files (x86)\\Mr DJ\\Grand Theft Auto IV\\common\\data\\ThrownWeaponInfo.xml"));
       filesToCopy.add(new File("vehicles - Copy.ide"));
       filesToSave.add(new File("D:\\Program Files (x86)\\Mr DJ\\Grand Theft Auto IV\\common\\data\\vehicles.ide"));*/
       
        for(int i=0; i<filesToCopy.size(); i++){
            Corruptor c = new Corruptor();
            String[] ignore = {"ROMAN"};
            c.corrupt(10.0, 10, ignore, filesToCopy.get(i), filesToSave.get(i));
        }
    }
    
}
