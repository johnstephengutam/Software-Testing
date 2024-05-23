import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import java.util.Set;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.Theory;

/* 
 * Fullname: John Stephen Gutam
 * GNumber: G01413212
 */

class EH {
    private int x;
    public EH(int x) { this.x = x; }

    @Override public boolean equals(Object obj) {
       if (!(obj instanceof EH)) return false;
       return ((EH) obj).x == this.x;
    }

    // @Override public int hashCode() { return x; }
 }
 
public class TakeHomeFinal/*-LName*/ {
       private EH eh1; private EH eh2; private EH eh3;
       private Set<EH> s;

       @Before public void setUp() { eh1 = new EH(3); eh2 = new EH(5); eh3 = new EH(3); s = new HashSet<EH>();}
       
       @Test
       public void NoNPE() {				// Question 2
           EH obj = new EH(3);
           assertFalse(obj.equals(null));
       }

       @Test
       public void equalsFalse() {  		// Question 2
           assertFalse(eh1.equals(eh2));
       }

       @Test public void equalsTrue() {     // Question 3
    	       assertTrue(eh1.equals(eh3));
       }
       
       @Test
       public void basicHash() {			//QUestion 4
           boolean consistent = eh1.equals(eh3) == (eh1.hashCode() == eh3.hashCode());
           assertTrue(consistent);
       }
		
       @Theory 
       public void theoryHash (EH obj1, EH obj2) { //Question 5
		  assumeTrue(obj1.equals(obj2)); 
		  assertTrue(obj1.hashCode() == obj2.hashCode()); 
	   }
		 
       
    }
    
    