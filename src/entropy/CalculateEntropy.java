/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entropy;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author moh
 */
public class CalculateEntropy {

    private Map<Character, Float> probability;
    private String s;

    public CalculateEntropy(String s) {
        this.s = s;
    }

    private Map<Character, Float> getProbability() {
        Map<Character, Float> duplicates = new HashMap<Character, Float>();
        for (int i = 0; i < this.s.length(); i++) {
            char charAt = this.s.charAt(i);
            if (duplicates.containsKey(charAt)) {
                duplicates.put(charAt, duplicates.get(charAt) + 1);
            } else {
                duplicates.put(charAt, 1f);
            }
        }

        for (Map.Entry<Character, Float> entry : duplicates.entrySet()) {
            duplicates.put(entry.getKey(), entry.getValue() / this.s.length());
        }
        return duplicates;
        
    }

    public double getLog2(float x) {
        return Math.log(x) / Math.log(2);
    }

    public void probabilityByLog() {
         this.probability = getProbability();
        for (Map.Entry<Character, Float> entry : this.probability.entrySet()) {
            this.probability.put(entry.getKey(), entry.getValue() * (float) getLog2(1 / entry.getValue()));
        }
    }

    public float sum() {
        probabilityByLog();
        float sum = 0.0f;
        for (float f : this.probability.values()) {
            sum += f;
        }
        return sum ;
    }

    @Override
    public String toString() {
        return "The Entropy For This String is "+ sum();
    }

}
