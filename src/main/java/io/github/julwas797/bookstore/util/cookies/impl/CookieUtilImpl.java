package io.github.julwas797.bookstore.util.cookies.impl;

import io.github.julwas797.bookstore.util.cookies.CookieUtil;
import io.github.julwas797.bookstore.util.serialization.SerializationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;

@Service
public class CookieUtilImpl<K, V> implements CookieUtil<K, V> {

    private final SerializationUtil<K, V> serializationUtil;

    @Autowired
    public CookieUtilImpl(SerializationUtil<K, V> serializationUtil) {
        this.serializationUtil = serializationUtil;
    }

    @Override
    public HashMap<K, V> getDeserializedCookies(String source) {
        return serializationUtil.deserializeHashMap(source);
    }

    @Override
    public void serializeAndSaveCookies(HashMap<K, V> source, HttpServletResponse response, String name, int lifespan) {
        var cookieMap = serializationUtil.serializeHashMap(source);
        var cookie = new Cookie(name, cookieMap);
        cookie.setMaxAge(lifespan);
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    @Override
    public void serializeAndSaveCookies(HashMap<K, V> source, HttpServletResponse response, String name) {
        serializeAndSaveCookies(source, response, name, 48000);
    }
}
