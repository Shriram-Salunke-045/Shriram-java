import java.util.*;
import java.security.*;

class SHA1_in_Java {
    public static void main(String argv[]) {
	try {
	    MessageDigest md = MessageDigest.getInstance("SHA");
	    byte[] testdata = new byte[30];
	    byte[] digest = md.digest(testdata);

	    for (int i=0; i<digest.length; i++)
		System.out.format("%02x", digest[i]);
	    System.out.println();

	} catch (Exception e) {
	    System.out.println("Exception "+e);
	}
    }
}