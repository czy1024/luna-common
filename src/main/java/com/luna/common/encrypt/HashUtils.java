package com.luna.common.encrypt;

import com.luna.common.text.CharsetKit;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;

/**
 * Md5加密方法
 *
 * @author luna
 */
public class HashUtils {

    /**
     * 获取文件或者字符串的MD5值
     *
     * @param data
     * @return
     */
    public static String md5(String data) {
        return EncryptUtils.dataEncryptByJdk(data, "MD5");
    }

    public static String md5WithFile(String path) {
        try {
            return md5(IOUtils.toInputStream(path, CharsetKit.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String md5(InputStream inputStream) {
        return EncryptUtils.streamEncryptByJdk(inputStream, "MD5");
    }

    public static String sha256(String data) {
        return EncryptUtils.dataEncryptByJdk(data, "SHA-256");
    }

    public static String sha256WithFile(String path) {
        try {
            return sha256(IOUtils.toInputStream(path, CharsetKit.UTF_8));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String sha256(InputStream inputStream) {
        return EncryptUtils.streamEncryptByJdk(inputStream, "SHA-256");
    }

    public static boolean checkFileWithSHA256(InputStream path, String sha256) {
        return StringUtils.equals(sha256(path), sha256);
    }

    public static boolean checkFileWithSHA256(String path, String md5) {
        return StringUtils.equals(sha256WithFile(path), md5);
    }

    public static boolean checkFileWithMd5(InputStream path, String md5) {
        return StringUtils.equals(md5(path), md5);
    }

    public static boolean checkFileWithMd5(String path, String md5) {
        return StringUtils.equals(md5WithFile(path), md5);
    }

    public static void main(String[] args) {
        String s = sha256("/Users/luna_mac/temp/settings.zip");
        System.out.println(s);

        System.out.println(checkFileWithSHA256("/Users/luna_mac/temp/settings.zip",
            "43a1ce4d77b0c3b47af2759c337341f76f88871b2ca8a1bb8c8d2b8e89755e5e"));
    }

}
