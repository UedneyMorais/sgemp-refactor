package controle;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Clock;

/**
 *
 * @author Uedney
 * Classe responsável por gerar o hash MD5
 */
public class HashMd5 {

    public static String HashMd5(String hash) {
        StringBuffer sb = new StringBuffer();
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(hash.getBytes());
            byte[] b = md.digest();

            for (byte b1 : b) {
                sb.append(Integer.toHexString(b1 & 0xff).toString());
            }
        } catch (NoSuchAlgorithmException e) {
        }
        return sb.toString();
    }
}
