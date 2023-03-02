package ir.dotin.registration.util;


import ir.dotin.registration.exception.InternalServerErrorException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

public class HashUtil {

    private HashUtil() {
    }

    public static String encryptPassword(String password) throws NoSuchAlgorithmException {
        if (password.isEmpty()) {
            throw new IllegalArgumentException();
        }
        String sha1 = "";
        MessageDigest crypt = MessageDigest.getInstance("SHA-1");
        crypt.reset();
        crypt.update(password.getBytes(StandardCharsets.UTF_8));
        sha1 = byteToHex(crypt.digest());
        return sha1;
    }

    private static String byteToHex(final byte[] hash) {
        Formatter formatter = new Formatter();
        for (byte b : hash) {
            formatter.format("%02x", b);
        }
        String result = formatter.toString();
        formatter.close();
        return result;
    }

    public static String toSha1(String in) {
        try {
            String sha1 = "";
            MessageDigest crypt = MessageDigest.getInstance("SHA-1");
            crypt.reset();
            crypt.update(in.getBytes(StandardCharsets.UTF_8));
            sha1 = byteToHex(crypt.digest());
            return sha1;
        } catch (Exception e) {
            throw new InternalServerErrorException(e);
        }

    }

}
