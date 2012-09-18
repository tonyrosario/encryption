package com.rosario.crypty.crypto.encrypt;

import static com.rosario.crypty.crypto.encrypt.CipherUtils.newCipher;
import static com.rosario.crypty.crypto.encrypt.CipherUtils.newSecretKey;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
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
		// TODO Auto-generated method stub
		return null;
	}

	public byte[] decrypt(byte[] encryptedBytes) {
		// TODO Auto-generated method stub
		return null;
	}

}
