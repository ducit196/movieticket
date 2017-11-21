/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package support;

/**
 *
 * @author MrDuc
 */
public class BatNgoaiLe {
    public static boolean loiString(String s){
        try {
            s.charAt(0);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
    
    public static boolean loiInt(String s){
        try {
            s.charAt(0);
            Integer.parseInt(s);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
