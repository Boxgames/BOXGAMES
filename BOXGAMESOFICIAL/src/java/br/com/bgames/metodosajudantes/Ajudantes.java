/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.bgames.metodosajudantes;


public class Ajudantes {  
    
     public static Long conversorCpf (String cpf){   
        String cpfS = cpf;
            long cpfL = 0;
                    for(int i = 0; i< cpfS.length(); i++){
                        char a;
                        int b;
                        a = cpfS.charAt(i);  
                        if (a == '1' || a == '2' ||a == '3' ||a == '4' ||a == '5' ||a == '6' ||a == '7' ||a == '8' ||a == '9' ||a == '0'){
                            b = ((int)a - 48);
                            cpfL = ((cpfL*10) + b);                       
                        }
                    }
        return cpfL;
    }
     
     
     public static Long conversorTel (String tel){ 
     String telS = tel;
         long telL = 0;
                for(int i = 0; i< telS.length(); i++){
                    char a;
                    int b;
                    a = telS.charAt(i);  
                    if (a == '1' || a == '2' ||a == '3' ||a == '4' ||a == '5' ||a == '6' ||a == '7' ||a == '8' ||a == '9' ||a == '0'){
                        b = ((int)a - 48);                        
                        telL = ((telL*10) + b);                        
                    }
                } 
         return telL;
     }  
}
