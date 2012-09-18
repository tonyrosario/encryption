package com.rosario.crypty.crypto.encrypt;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AESBytesEncryptorTest {
	private AESBytesEncryptor encryptor;
	
	@Before
	public void setup() {
		encryptor = new AESBytesEncryptor();
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
