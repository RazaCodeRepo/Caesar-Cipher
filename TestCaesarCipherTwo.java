
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
public class TestCaesarCipherTwo {
    
    public String halfOfString(String message,int start){
        String halfString = "";
        for(int i=start;i<message.length();i=i+2){
            char currChar = message.charAt(i);
            halfString = halfString + currChar;
        }
        return halfString.toString();
    }
    
    public int[] countLetters(String input){
        StringBuilder deci = new StringBuilder(input);
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        for(int i=0;i<deci.length();i++){
            char currChar = deci.charAt(i);
            if(Character.isUpperCase(currChar) == true){
                String alphabet_upper = alphabet.toUpperCase();
                int index = alphabet_upper.indexOf(currChar);
                if(index != -1){
                    counts[index] +=1;
                }
            }
            else{
                int index = alphabet.indexOf(currChar);
                if(index != -1){
                    counts[index] += 1;
                }
            }
        }
        
        return counts;
        
    }
    
    
    
    public int maxIndex(int[] vals){
        int maxDex = 0;
        for(int i=0;i<vals.length;i++){
            if(vals[i] > vals[maxDex]){
                maxDex = i;
            }
        }
        return maxDex;
    }
    
     public int getKey(String s){
        int[] counts = countLetters(s);
        int index = maxIndex(counts);
        int dkey = index -4;
        if(index < 4){
            dkey = 26 - (4-index);
        }
        return dkey;
    }
    
    public String breakCaesarCipher(String input){
        
        String halfOne = halfOfString(input,0);
        String halfTwo = halfOfString(input,1);
        int keyOne = getKey(halfOne);
        int keyTwo = getKey(halfTwo);
        System.out.println("Key One: " + keyOne);
        System.out.println("Key Two: " + keyTwo);
        CaesarCipherTwo cc = new CaesarCipherTwo(26-keyOne,26-keyTwo);
        String result = cc.encrypt(input);
        return result;
    }
    
    public void simpleTests(){
        FileResource f = new FileResource();
        String input = f.asString();
        CaesarCipherTwo cc = new CaesarCipherTwo(14,24);
        String encrypt = cc.encrypt(input);
        System.out.println("Encrypted input is : " + encrypt);
        String decrypt = cc.decrypt(input);
        System.out.println("Decrypted input is : " + decrypt);
       
        
    }
    
}
