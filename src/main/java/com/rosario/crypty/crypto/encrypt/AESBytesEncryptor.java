package com.rosario.crypty.crypto.encrypt;

import static com.rosario.crypty.crypto.encrypt.CipherUtils.newCipher;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

import com.rosario.crypty.crypto.keygen.BytesKeyGenerator;

public class AESBytesEncryptor implements BytesEncryptor {
	
	private final SecretKey secretKey;
	
	private final Cipher encryptor;
	
	private final Cipher decryptor;
	
	private final BytesKeyGenerator ivGenerator;
	
	private static final String AES_ALGORITHM = "AES/CBC/PKCS5Padding";
	
	public AESBytesEncryptor(BytesKeyGenerator ivGenerator) {
		this.secretKey = null; //TODO
		
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
