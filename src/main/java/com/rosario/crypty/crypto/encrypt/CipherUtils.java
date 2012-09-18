package com.rosario.crypty.crypto.encrypt;

import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

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
	 * Generates a SecretKey
	 */
	public static SecretKey newSecretKey(String algorithm, int keySize) {
		try {
			KeyGenerator keyGenerator = KeyGenerator.getInstance(algorithm);
			keyGenerator.init(keySize);
			return  keyGenerator.generateKey();
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("Invalid encryption algorithm", e);
		}
		
	}
	
	/**
	 * Constructs a new Cipher.
	 * @param algorithm - algorithm to use, i.e. "AES/CBC/PKCS5Padding".
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
