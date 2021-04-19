package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/*Encode and Decode TinyURL
Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
and it returns a short URL such as http://tinyurl.com/4e9iAk.
Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work.
You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.*/
public class S_0535_EncodeAndDecodeTinyURL {
    Map<String, String> pairs;

    public S_0535_EncodeAndDecodeTinyURL() {
        pairs = new HashMap<>();
    }

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String sh = "";
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        for (int i = 0; i < 6; i++) {
            sh += chars.charAt((int) (Math.random() * chars.length()));
        }
        pairs.put(sh, longUrl);
        System.out.println("shorturl = "+"http://tinyurl.com/" + sh);
        return "http://tinyurl.com/" + sh;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        System.out.println("decoded longurl = "+pairs.get(shortUrl.substring(19)));
        return pairs.get(shortUrl.substring(19));
    }


    public static void main(String[] args) {
        S_0535_EncodeAndDecodeTinyURL codec = new S_0535_EncodeAndDecodeTinyURL();
        String input = "https://leetcode.com/problems/design-tinyurl";
        System.out.println("input url = "+input);
        String sh = codec.encode(input);
        codec.decode(sh);
    }
}

