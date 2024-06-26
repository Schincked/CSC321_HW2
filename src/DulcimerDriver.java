import java.awt.Font;

/**
 * Driver class for the keyboard-based virtual dulcimer.
 * 
 * @author Dexter Schincke
 * @version 28 September 2022
 */
public class DulcimerDriver {
   public static void main(String[] args) {
    String treble1Keys = "1   2   3   4   5   6   7   8   9   0   -   =";
    String treble1Notes = "G# A+ B+  C#+ D+  E+  F#+ G+  A++  B++  C++  D++";
    String treble2Keys = "q   w   e   r   t   y   u   i   o   p   [   ]";
    String treble2Notes = "C#  D   E   F#  G   A+  B+  C+  D+  E+  F#+ G+";
    String bassKeys = "a   s   d   f   g   h   j   k   l   ;   '";
    String trebleDashes = "--- --- --- --- --- --- --- --- --- --- --- ---";
    String bassDashes = "--- --- --- --- --- --- --- --- --- --- ---";
    String bassNotes = "G-  A   B   C   D   E   F   G   A+  A#+ C+";

        
    StdDraw.setFont(new Font("Monospaced", Font.PLAIN, 12));
    StdDraw.textLeft(0.00, 1.00, "DULCIMER KEY MAPPINGS");

    StdDraw.textLeft(0.00, 0.90, "        keys:  " + treble1Keys);
    StdDraw.textLeft(0.00, 0.87, "TREBLE 1      " + trebleDashes);
    StdDraw.textLeft(0.00, 0.84, "       notes:  " + treble1Notes);

    StdDraw.textLeft(0.00, 0.60, "        keys:  " + treble2Keys);
    StdDraw.textLeft(0.00, 0.57, "TREBLE 2      " + trebleDashes);
    StdDraw.textLeft(0.00, 0.54, "       notes:  " + treble2Notes);

    StdDraw.textLeft(0.00, 0.30, "        keys:  " + bassKeys);
    StdDraw.textLeft(0.00, 0.27, "BASS          " + bassDashes);
    StdDraw.textLeft(0.00, 0.24, "       notes:  " + bassNotes);

        
        String keys = (treble1Keys + treble2Keys + bassKeys).replace(" ","");  
        
        Dulcimer dulc = new Dulcimer(treble1Notes + " " + treble2Notes + " " + bassNotes);
        while (true) { 
            if (StdDraw.hasNextKeyTyped()) {
                int typed = keys.indexOf(StdDraw.nextKeyTyped());
                dulc.hammer(typed);
            }
            dulc.play();
        }
    }    
}
