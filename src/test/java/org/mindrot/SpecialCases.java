package org.mindrot;
import junit.framework.TestCase;

public class SpecialCases extends TestCase {
	/**
	 * Test for correct hashing of non-US-ASCII passwords
	 */
	public void testBcrypt12() {

		String pw1 = "1234";
		String pw2 = "abcd";
		String pw3 = "Crypt!@#";
		String pw4 = "simple";
		String pw5 = "6713";
		String h1 = BCrypt.hashpw(pw1, BCrypt.gensalt(12));
		String h2 = BCrypt.hashpw(pw2, BCrypt.gensalt(12));
		String h3 = BCrypt.hashpw(pw3, BCrypt.gensalt(12));
		String h4 = BCrypt.hashpw(pw4, BCrypt.gensalt(12));
		String h5 = BCrypt.hashpw(pw5, BCrypt.gensalt(12));

		// Comparison
		assertTrue(BCrypt.checkpw(pw1, h1));
		assertTrue(BCrypt.checkpw(pw2, h2));
		assertTrue(BCrypt.checkpw(pw3, h3));
		assertTrue(BCrypt.checkpw(pw4, h4));
		assertTrue(BCrypt.checkpw(pw5, h5));
	}

}
