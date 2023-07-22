package io.github.julwas797.bookstore.util.cookies;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

public interface CookieUtil<K, V> {
    HashMap<K, V> getDeserializedCookies(String source);

    void serializeAndSaveCookies(HashMap<K, V> source, HttpServletResponse response, String name);

    void serializeAndSaveCookies(HashMap<K, V> source, HttpServletResponse response, String name, int lifespan);
}
