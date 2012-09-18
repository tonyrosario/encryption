package com.rosario.crypty.crypto.encrypt;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/**
 * Static helper for working with Cipher API.
 * 
 * Note: this should also help with reducing exception handling code in our
 * encryption API.
 * 
 * @author trosario
 * 
 */
public class CipherUtils {

	/**
	 * Constructs a new Cipher.
	 * @param algorithm - algorithm to use, i.e. "AES".
	 */
	public static Cipher newCipher(String algorithm) {
		try {
			return Cipher.getInstance(algorithm);
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("Not a valid encryption algorithm", e);
		} catch (NoSuchPaddingException e) {
			throw new IllegalStateException("Should not happen", e);
		}
	}

}
