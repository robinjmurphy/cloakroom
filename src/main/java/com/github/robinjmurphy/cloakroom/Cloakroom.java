package com.github.robinjmurphy.cloakroom;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cloakroom<T> {

    private Map<Token, T> map = new ConcurrentHashMap<Token, T>();

    public Token checkIn(T object) {
        Token token = new Token();
        map.put(token, object);
        return token;
    }

    public T pickUp(Token token) {
        return map.get(token);
    }

}
