/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entropy;

import java.util.HashSet;
import java.util.Map.Entry;

/**
 *
 * @author moh
 */
public class Entropy {

    public static void main(String[] args) {
      
       CalculateEntropy c = new CalculateEntropy("abaababbbb");
        System.out.println(c);
    }

}
