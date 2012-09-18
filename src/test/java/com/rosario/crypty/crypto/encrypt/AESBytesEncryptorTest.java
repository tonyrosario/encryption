package com.rosario.crypty.crypto.encrypt;

import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.rosario.crypty.crypto.keygen.BytesKeyGenerator;


public class AESBytesEncryptorTest {
	private AESBytesEncryptor encryptor;
	
	private BytesKeyGenerator ivGenerator;
	
	@Before
	public void setup() {
		ivGenerator = new BytesKeyGenerator();
		encryptor = new AESBytesEncryptor(ivGenerator);
	}
	
	@Test
	public void encryptReturnsNull() {
		assertNull(encryptor.encrypt(null));
	}
	
	@Test
	public void decryptReturnsNull() {
		assertNull(encryptor.decrypt(null));
	}
}
