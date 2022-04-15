import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;

public class RSA_USING_API
{
    public static KeyPair keyPair;
    public static PublicKey publickey;
    public static PrivateKey privateKey;

    public RSA_USING_API() throws NoSuchAlgorithmException
    {
        KeyPairGenerator keyPairGenerator=KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        keyPair=keyPairGenerator.genKeyPair();
        publickey=keyPair.getPublic();
        privateKey=keyPair.getPrivate();
    }
    public void encrypt(String filePath) throws NoSuchAlgorithmException,NoSuchPaddingException, InvalidKeyException,FileNotFoundException,IOException
    {
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publickey);
        FileInputStream fis=new FileInputStream(filePath);
        FileOutputStream fos=new FileOutputStream("H:\\workspace\\ICS\\src\\ctext.txt");
        CipherOutputStream cos=new CipherOutputStream(fos,cipher);
        byte[] bytes=new byte[30];
        int i=0;
        while((i=fis.read(bytes))!=-1)
        {
            cos.write(bytes,0,i);

        }
        cos.close();
    }
    public void decrypyt(String filePath) throws NoSuchAlgorithmException,NoSuchPaddingException,InvalidKeyException,FileNotFoundException,IOException
    {
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        FileInputStream fis=new FileInputStream(filePath);
        FileOutputStream fos=new FileOutputStream("H:\\workspace\\ICS\\src\\dtext.txt");
        CipherOutputStream cos=new CipherOutputStream(fos,cipher);
        byte[] bytes=new byte[30];
        int i=0;
        while((i=fis.read(bytes))!=-1)
        {
            cos.write(bytes,0,i);

        }
        cos.close();

    }


    public static void main(String[] args) throws  NoSuchAlgorithmException,NoSuchPaddingException,InvalidKeyException,IOException
    {
        RSA_USING_API m1=new RSA_USING_API();
        m1.encrypt("H:\\workspace\\ICS\\src\\ptext.txt");
        m1.decrypyt("H:\\workspace\\ICS\\src\\ctext.txt");


    }
}
