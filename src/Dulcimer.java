import java.util.ArrayList;

/**
 * Class that models a dulcimer. Currently, only the bass strings are represented.
 * 
 * @author Dexter Schincke
 * @version 09/28/2022
 */
public class Dulcimer {
    public ArrayList<DulcimerString> allStrings;

    /**
     * Constructs a Dulcimer with the specified bass strings.
     *   @param notes a String specifying the treble1 notes, treble2 notes, and bass notes, from top to bottom
     */
    public Dulcimer(String notes) {
        this.allStrings = new ArrayList<DulcimerString>();
        for (String str : notes.split("\\s+")) {
            this.allStrings.add(new DulcimerString(str));
        } 
    }
    
    /**
     * Strikes the specified string and sets it to vibrating.
     *   @param stringNum the string number (starting at the bottom with 0)
     */
    public void hammer(int stringNum) {
        if (stringNum >= 0 && stringNum < this.allStrings.size()) {
            this.allStrings.get(stringNum).strike();
        }
    }

    /**
     * Plays the sounds corresponding to all of the struck strings.
     */
    public void play() {
        double combinedFrequencies = 0.0;
        for (int i = 0; i < this.allStrings.size(); i++) {
            combinedFrequencies += this.allStrings.get(i).sample();
        }
        StdAudio.play(combinedFrequencies);
    }
}
