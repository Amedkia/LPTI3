/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Crypto;

/**
 *
 * @author Easysoft Company
 */
public class Crypter16914 {
   
    
    public String code (String to_code)
    { 
        StringBuilder coded = new StringBuilder();
        
        
        for(int i = 0; i < to_code.length();i++)
        {
            char c = to_code.charAt(i);
            if       (c >= 'a' && c <= 'm') c += 2;
            else if  (c >= 'A' && c <= 'M') c += 4;
            else if  (c >= 'n' && c <= 'z') c += 2;
            else if  (c >= 'N' && c <= 'Z') c += 4;
            
            coded.append(c);
           
        }
        
        return coded.toString();
    }
    
    public String decode (String to_decode)
    {
        StringBuilder decoded = new StringBuilder();
        
        
        for(int i = 0; i < to_decode.length();i++)
        {
            char c = to_decode.charAt(i);
            if       (c >= 'a' && c <= 'm') c -= 2;
            else if  (c >= 'A' && c <= 'M') c -= 4;
            else if  (c >= 'n' && c <= 'z') c -= 2;
            else if  (c >= 'N' && c <= 'Z') c -= 4;
            
            decoded.append(c);
           
        }
        
        return decoded.toString();
    }
    
}
