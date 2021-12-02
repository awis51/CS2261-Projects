package umsl.edu.Project3;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Base64 extends org.apache.commons.codec.binary.Base64 {
    private static String data;

    public Base64(String data){
        Base64.data = data;}

    public void encode() {
        System.out.println("Enter string you want encoded: ");
        Scanner scan = new Scanner(System.in);
        data = scan.nextLine();
        String result = encodeBase64String(data.getBytes(StandardCharsets.UTF_8));
        System.out.println(result);
    }

    public void decode() {
       data = "SSBsb3ZlIG15IENNUCBTQ0kgMjI2MSBjbGFzcyBzbyBtdWNoLCBJIHdpc2ggSSBjb3VsZCBiZSBqdXN0IGFzIGNvb2wgYXMgbXkgcHJvZmVzc29y";
       byte[] result = decodeBase64(data);
       System.out.println(new String(result));

    }

    public static void main(String[] args){
        try{
            Base64 base64 = new Base64(data);
            base64.encode();
            base64.decode();
        } catch(Exception e){
            System.out.println("Whoops something went wrong!");

        }
    }
}
