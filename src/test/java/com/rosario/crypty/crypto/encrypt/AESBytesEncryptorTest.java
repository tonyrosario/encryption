package com.rosario.crypty.crypto.encrypt;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

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
	public void encryptedDataHasLengthOf48Bytes() throws InvalidKeyException,
			InvalidAlgorithmParameterException, IllegalBlockSizeException,
			BadPaddingException, NoSuchAlgorithmException, InvalidKeySpecException {
		String stringToEncrypt = "My super secret 1337 P@SSW0rDz";

		byte[] result = encryptor.encrypt(stringToEncrypt.getBytes());

		//System.out.println("before: " + stringToEncrypt);
		//System.out.println("after : " + new String(result));

		assertEquals(48, result.length); // 32 (data) + 16 (iv)
	}
	
	@Test
	public void decryptReturnsNull() {
		assertNull(encryptor.decrypt(null));
	}
}
