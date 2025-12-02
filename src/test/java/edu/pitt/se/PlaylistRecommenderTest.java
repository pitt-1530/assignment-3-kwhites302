package edu.pitt.se;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class PlaylistRecommenderTest {

    @Test
    public void classifyEnergyTest() {
        List<Integer> testDBM = new ArrayList<>();

        testDBM.add(10);
        testDBM.add(15);
        testDBM.add(13);
        testDBM.add(14);
        testDBM.add(15);

        String energy = PlaylistRecommender.classifyEnergy(testDBM);

        assertEquals(energy, "LOW");
    }

    @Test
    public void validTitleTest() {
        String badTitle = "Gh&";
        
        boolean isValid = PlaylistRecommender.isValidTrackTitle(badTitle);
        
        assertFalse(isValid);
    }

        @Test
    public void invalidTitleTest() {
        String badTitle = "";
                
        assertThrows(UnsupportedOperationException.class, () -> {
            PlaylistRecommender.isValidTrackTitle(badTitle);
        });
    }

    @Test 
    public void normalizeVolumeTest() {
        int testVolume = 150;

        int normalizedVolume = PlaylistRecommender.normalizeVolume(testVolume);

        assertEquals(normalizedVolume, 100);
    }
}
