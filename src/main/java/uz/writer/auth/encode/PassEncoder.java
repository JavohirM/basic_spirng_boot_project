package uz.writer.auth.encode;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import uz.writer.config.data.JwtConfigData;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;

@Component
public class PassEncoder implements PasswordEncoder {
     private final JwtConfigData jwtConfigData;

    public PassEncoder(JwtConfigData jwtConfigData) {
        this.jwtConfigData = jwtConfigData;
    }


    @Override
    public String encode(CharSequence charSequence) {
        try{
            byte[] pbkdf2WithHmacSHA512s = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512")
                    .generateSecret(
                            new PBEKeySpec(
                                    charSequence.toString().toCharArray(),
                                    jwtConfigData.getPassword().getEncode().getSecret().getBytes(),
                                    jwtConfigData.getPassword().getEncode().getIteration(),
                                    jwtConfigData.getPassword().getEncode().getKeyLength()
                            )
                    ).getEncoded();
            return Base64.getEncoder().encodeToString(pbkdf2WithHmacSHA512s);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encode(rawPassword).equals(encodedPassword);
    }
}
