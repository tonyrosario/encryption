package com.rosario.crypty.crypto.keygen;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class BytesKeyGenerator {
	private final SecureRandom random;
	private final int keyLength;

	private static final String DEFAULT_ALGORITHM = "SHA1PRNG";
	private static final int DEFAULT_KEY_LENGTH = 16;

	public BytesKeyGenerator() {
		this(DEFAULT_ALGORITHM, DEFAULT_KEY_LENGTH);
	}

	public BytesKeyGenerator(int keyLength) {
		this(DEFAULT_ALGORITHM, keyLength);
	}

	public int getKeyLength() {
		return keyLength;
	}

	public byte[] generateKey() {
		byte[] bytes = new byte[keyLength];
		random.nextBytes(bytes);
		return bytes;
	}

	private BytesKeyGenerator(String algorithm, int keyLength) {
		this.random = createSecureRandom(algorithm, keyLength);
		this.keyLength = keyLength;
	}

	private SecureRandom createSecureRandom(String algorithm, int keyLength) {

		try {
			SecureRandom random = SecureRandom.getInstance(algorithm);

			return random;
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException(
					"Not a supported SecureRandom key generation algorithm", e);
		}
	}
}