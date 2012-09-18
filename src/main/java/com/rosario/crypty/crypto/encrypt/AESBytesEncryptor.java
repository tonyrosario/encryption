package com.rosario.crypty.crypto.encrypt;

import static com.rosario.crypty.crypto.encrypt.CipherUtils.newCipher;
import static com.rosario.crypty.crypto.encrypt.CipherUtils.newSecretKey;
import static com.rosario.crypty.crypto.encrypt.CipherUtils.initCipher;
import static com.rosario.crypty.crypto.encrypt.CipherUtils.doFinal;
import static com.rosario.crypty.crypto.util.EncodingUtils.concatenate;
import static com.rosario.crypty.crypto.util.EncodingUtils.subArray;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import com.rosario.crypty.crypto.keygen.BytesKeyGenerator;

public class AESBytesEncryptor implements BytesEncryptor {
	
	private final SecretKey secretKey;
	
	private final Cipher encryptor;
	
	private final Cipher decryptor;
	
	private final BytesKeyGenerator ivGenerator;
	
	private static final String AES_ALGORITHM = "AES/CBC/PKCS5Padding";
	
	private static final String ALGORITHM = "AES";
	
	private static final int KEYSIZE = 128;
	
	public AESBytesEncryptor(BytesKeyGenerator ivGenerator) {
		SecretKey secretKey = newSecretKey(ALGORITHM, KEYSIZE);
		this.secretKey = new SecretKeySpec(secretKey.getEncoded(), ALGORITHM);
		
		this.encryptor = newCipher(AES_ALGORITHM);
		this.decryptor = newCipher(AES_ALGORITHM);
		
		this.ivGenerator = ivGenerator;
	}

	public byte[] encrypt(byte[] bytes) {
		byte[] iv = ivGenerator.generateKey();
		IvParameterSpec ivspec = new IvParameterSpec(iv);

		initCipher(encryptor, Cipher.ENCRYPT_MODE, secretKey, ivspec);

		byte[] encrypted = doFinal(encryptor, bytes);

		return concatenate(iv, encrypted);
	}

	public byte[] decrypt(byte[] encryptedBytes) {
		byte[] iv = extractIv(encryptedBytes);
		initCipher(decryptor, Cipher.DECRYPT_MODE, secretKey, new IvParameterSpec(iv));
		return doFinal(decryptor, extractEncrypted(encryptedBytes, iv));
		
	}

	private byte[] extractIv(byte[] encrypted) {
		return subArray(encrypted, 0, ivGenerator.getKeyLength());
	}
	
	private byte[] extractEncrypted(byte[] encryptedBytes, byte[] iv) {
		return subArray(encryptedBytes, iv.length, encryptedBytes.length);
	}
}
