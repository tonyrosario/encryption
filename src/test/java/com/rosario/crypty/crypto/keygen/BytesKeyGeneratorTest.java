package com.rosario.crypty.crypto.keygen;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BytesKeyGeneratorTest {
       private BytesKeyGenerator generator ;
      
       @Before
       public void setup() {
             generator = new BytesKeyGenerator();
      }
      
       @Test
       public void keyLengthIs16Bytes() {
             assertEquals(16, generator.getKeyLength());
      }
      
       @Test
       public void generateKeyReturns16LengthByteArray() {
             byte[] result = generator .generateKey();
            
             assertEquals(16, result.length);
      }
      
       @Test
       public void keyLengthConstructorSetsKeyLength() {
             generator = new BytesKeyGenerator(8);
            
             assertEquals(8, generator.getKeyLength());
      }
      
       //@Test(expected=IllegalArgumentException.class)
//    public void invalidAlgortihmThrowsIllegalArgumentException() {
//          new BytesKeyGenerator("", 16);
//    }
      
}
