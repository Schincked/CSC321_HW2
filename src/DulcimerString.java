import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.Arrays;
import java.util.Random;


/**
 * Class for the DulcimerString methods, objects, and constructors.
 * 
 * @author Dexter Schincke
 * @version 28 September 2022
 */
public class DulcimerString {
    private String dulcimerNote;
    private Queue<Double> myQueue;
    private List<String> chromatic = Arrays.asList("A","A#","B","C","C#","D","D#","E","F","F#","G","G#");
    private Random randomNum = new Random();

    /**
     * Creates a queue of 0.0 based on the given string of notes and offsets that each note to a corresponding value.
     *   @param note a String specifying the notes from treble1, treble2, and bass
     */
    public DulcimerString(String note) {
        this.dulcimerNote = note;
        int noteOffset = getOffsetFromMiddleC();
        int queueLength = (int) Math.round(StdAudio.SAMPLE_RATE * Math.pow(2, (22.0 - noteOffset)/12) / 440);

        myQueue = new LinkedList<>();
        for(int i = 0; i < queueLength; i++) {
            myQueue.add(0.0);
        }

    }

    /**
     * Gets the note information
     *   @return the note
     */
    public String getNote() {
        return this.dulcimerNote;
    }


    /**
     * Offsets the note information based on if the note has a "+" or "-" character
     *   @return the total offset value for the note.
     */
    public int getOffsetFromMiddleC() {
        
        String dulcimerNote = this.getNote();
        int noteOffset = chromatic.indexOf(dulcimerNote.replace("+", "").replace("-", ""));

        for (int letter = 0; letter < dulcimerNote.length(); letter++) {
            char c = dulcimerNote.charAt(letter);
            //System.out.println(c);
            if (c == '+') {
                noteOffset += 12;
            }

            if (c == '-') {
                noteOffset -= 12;
            }
        }
        
        return noteOffset - 3;
    }


    /**
     * Acts as a striking method for the dulcimer by iterating through the queue and replacing all of the values with a random number between -0.5 and 0.5.
     * 
     */
    public void strike() {

        int count = 0;

        while (count < myQueue.size()) {
            myQueue.poll();
            myQueue.add(randomNum.nextDouble() - 0.5);
            count += 1;
        }

    }

    /**
     * Gets and removes the value at the front of the queue while adding the energy decay factor multiplied by the average of the first two elements of the queue to the back of the queue.
     *   @return a double value representing the first value in the queue.
     */
    public double sample() {
        Double a = myQueue.poll();
        Double b = myQueue.peek();

        myQueue.add(0.996 * ((a + b) / 2));
        return a;
    }

}
