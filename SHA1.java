import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class SHA1 {

 public SHA1(){
  
 }
 
 public static void main(String args[]) throws NoSuchAlgorithmException, FileNotFoundException , IOException{
  
  MessageDigest messageDigest = MessageDigest.getInstance("MD5");
  FileInputStream fileInputStream = new FileInputStream("H:\\workspace\\ICS\\src\\messageDigest.txt");
  
  byte[] bytes = new byte[30];
  int i=0;
  while((i=fileInputStream.read(bytes))!=-1)
  {
   messageDigest.update(bytes , 0 , i);
  }
  
  fileInputStream.close();
  byte[] digest = messageDigest.digest();
  
  FileOutputStream fileOutputStream = new FileOutputStream("H:\\workspace\\ICS\\src\\digest.txt");
  fileOutputStream.write(digest);
  fileOutputStream.close();
  
 }
 
}