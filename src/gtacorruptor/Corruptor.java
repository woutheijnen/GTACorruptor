/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gtacorruptor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Wout
 */
public class Corruptor {
    private ArrayList<String> text = new ArrayList<>();
    int i = 0;
    private File fout;
    
    public void corrupt(double level, int interval, String[] ignore, File fin, File fout){
        this.fout = fout;
        Random r = new Random();
        try (BufferedReader br = new BufferedReader(new FileReader(fin))) {
            String line;
            while ((line = br.readLine()) != null) {
                Pattern pattern = Pattern.compile("-?[0-9]+(\\.[0-9]+)?"); 
                Matcher matcher = pattern.matcher(line);
                
                Boolean noAdd = false;
                for(int i=0; i<ignore.length; i++){
                    if(!noAdd){
                        if(line.toLowerCase().contains(ignore[i].toLowerCase())){
                            noAdd = true;
                            break;
                        }
                    }
                }
                
                if(noAdd)
                    text.add(line);
                
                // Find all matches
                while (matcher.find()) {
                  // Get the matching string
                  boolean isNegatif = false;
                  boolean isDecimal = false;
                  if(matcher.group().contains("-"))
                      isNegatif = true;
                  if(matcher.group().contains("."))
                      isDecimal = true;
                  
                  if(isDecimal){
                    double number = Double.parseDouble(matcher.group());
                    double rangeMin = 0.0;
                    double rangeMax = number * level;
                    if(isNegatif){
                        rangeMin = number * level;
                        rangeMax = number * level * -1;
                        if(rangeMin>rangeMax){
                            double temp = rangeMin;
                            rangeMin = rangeMax;
                            rangeMax = temp;
                        }
                    }else{
                        rangeMin = number / level;
                    }
                    number = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
                    String temp = String.valueOf(number);
                    String[] temp1 = temp.split("\\.");
                    String[] temp2 = matcher.group().split("\\.");
                    if(temp2[1].length()<temp1[1].length())
                        temp1[1] = temp1[1].substring(0, temp2[1].length());
                    String trimmed = temp1[0] + "." + temp1[1];
                    
                    if((r.nextInt(100)+1) <= interval)
                        line = line.replaceAll(matcher.group(), trimmed);
                  }else{
                    int number = Integer.parseInt(matcher.group());
                   if(number == 0)
                        number ++;
                    int rangeMin = 0;
                    int rangeMax = number * ((int) level);
                    if(isNegatif){
                        rangeMin = number * ((int) level);
                        rangeMax = number * ((int) level) * -1;
                        if(rangeMin>rangeMax){
                            int temp = rangeMin;
                            rangeMin = rangeMax;
                            rangeMax = temp;
                        }
                    }else{
                        rangeMin = number / ((int) level);
                    }
                    if(rangeMax<0){
                        number = rangeMin + (r.nextInt(rangeMax * -1) *-1);
                    }else{
                        rangeMax ++;
                        number = rangeMin + r.nextInt(rangeMax);
                    }
                    if((r.nextInt(100)+1) <= interval)
                        line = line.replaceAll(matcher.group(), String.valueOf(number));
                  }
                }
                if(!noAdd)
                    text.add(line);
            }
            writeFile();
        } catch (IOException ex) {
            Logger.getLogger(Corruptor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void writeFile() throws IOException {
	FileOutputStream fos = new FileOutputStream(fout);
 
	BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
 
	for (int i=0; i<text.size(); i++) {
		bw.write(text.get(i));
		bw.newLine();
	}
        text.clear();
	bw.close();
    }
}
