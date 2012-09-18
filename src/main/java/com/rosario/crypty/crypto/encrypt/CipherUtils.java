package com.rosario.crypty.crypto.encrypt;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
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
	
	/**
	 * Initializes the cipher for use.
	 * 
	 * For AES CBC encryption, ALWAYS use an IvParameterSpec (AlgorithmParameterSpec)
	 * so that the first block, 16 bytes, are randomized.
	 * 
	 * @param cipher
	 * @param mode
	 * @param secretKey
	 * @param parameterSpec
	 */
	public static void initCipher(Cipher cipher, int mode, SecretKey secretKey, AlgorithmParameterSpec parameterSpec) {
		try {
			if (parameterSpec != null) {
				cipher.init(mode, secretKey, parameterSpec);
			} else {
				cipher.init(mode, secretKey);
			}
		} catch (InvalidKeyException e) {
			throw new IllegalArgumentException("Unable to initialize due to invalid secret key", e);
		} catch (InvalidAlgorithmParameterException e) {
			throw new IllegalArgumentException("Unable to initialize due to invalid decryption parameter spec", e);
		}
		
	}
	
	public static byte[] doFinal(Cipher cipher, byte[] input) {
		try {
			return cipher.doFinal(input);
		} catch (IllegalBlockSizeException e) {
			throw new IllegalStateException("Unable to invoke Cipher due to illegal block size", e);
		} catch (BadPaddingException e) {
			throw new IllegalStateException("Unable to invoke Cipher due to bad padding", e);
		} 
		
	}
}
