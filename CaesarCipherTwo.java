
/**
 * Write a description of CaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class CaesarCipherTwo {
    
    private String alphabet = "";
    private String shiftedAlphabet1 = "";
    private String shiftedAlphabet2 = "";
    private int mainKey1 = 0;
    private int mainKey2 = 0;
    public CaesarCipherTwo(int key1,int key2){
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0,key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0,key2);
        mainKey1 = key1;
        mainKey2 = key2;
    }
    
    public String encrypt(String input){
        StringBuilder encrypted = new StringBuilder(input);
        for(int i = 0; i < encrypted.length();i+=2){
            char currChar = encrypted.charAt(i);
            if(Character.isLowerCase(currChar) == true){
                String lowerAlphabet = alphabet.toLowerCase();
                int idx = lowerAlphabet.indexOf(currChar);
                if(idx != -1){
                    String shifted_lowerAlphabet = shiftedAlphabet1.toLowerCase();
                    char newChar = shifted_lowerAlphabet.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
            
            else{
                int idx = alphabet.indexOf(currChar);
                if(idx != -1){
                    
                    char newChar = shiftedAlphabet1.charAt(idx);
                    encrypted.setCharAt(i,newChar);
                }
            }
         
        }
        
        for(int j = 1; j < encrypted.length();j+=2){
            char currChar = encrypted.charAt(j);
            if(Character.isLowerCase(currChar) == true){
                String lowerAlphabet = alphabet.toLowerCase();
                int idx = lowerAlphabet.indexOf(currChar);
                if(idx != -1){
                    String shifted_lowerAlphabet = shiftedAlphabet2.toLowerCase();
                    char newChar = shifted_lowerAlphabet.charAt(idx);
                    encrypted.setCharAt(j,newChar);
                }
            }
            
            else{
                int idx = alphabet.indexOf(currChar);
                if(idx != -1){
                    
                    char newChar = shiftedAlphabet2.charAt(idx);
                    encrypted.setCharAt(j,newChar);
                }
            }
         
        }
        return encrypted.toString();
    }
    
    public String decrypt(String input){
        
        String decrypt = "";
        CaesarCipherTwo cc = new CaesarCipherTwo(26-mainKey1,26-mainKey2);
        decrypt = cc.encrypt(input);
        return decrypt;
    }
}
