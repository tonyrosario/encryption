package com.rosario.crypty.crypto.encrypt;

/**
 * Service interface for symmetric data encryption.
 * @author trosario
 *
 */
public interface BytesEncryptor {
	/**
	 * Encrypts the byte array.
	 */
	byte[] encrypt(byte[] bytes);
	
	/**
	 * Decrypts the byte array.
	 */
	byte[] decrypt(byte[] encryptedBytes);
	
}
