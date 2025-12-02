package edu.pitt.se;

import java.nio.channels.UnsupportedAddressTypeException;
import java.util.List;

public class PlaylistRecommender {

    public static String classifyEnergy(List<Integer> bpms) {
        if(bpms.isEmpty() || bpms == null) {
            throw new UnsupportedOperationException("Invalid input");
        }

        int sum = 0, count = 0, average = 0;

        for(Integer a: bpms) { 
            sum += a;
            count++;
        }
        
        average = sum / count;

        if(average >= 140) {
            return "HIGH";
        } else 
        if(average >= 100) {
            return "MEDIUM";
        } else {
            return "LOW";
        }
    }

    public static boolean isValidTrackTitle(String title) {
        if(title.isEmpty() || title == null) {
            throw new UnsupportedOperationException();
        }

        for(int i = 0; i < title.length(); i++) {
            if(i > 30) {
                return false;
            }

            if(!Character.isLetterOrDigit(title.charAt(i)) && !Character.isWhitespace(title.charAt(i))) {
                return false;
            }
        }

        return true;
    }

    public static int normalizeVolume(int volumeDb) {
        if(volumeDb > 100) {
            return 100;
        } 
        if(volumeDb < 0) {
            return 0;
        }
    
        return volumeDb;
    }
}
