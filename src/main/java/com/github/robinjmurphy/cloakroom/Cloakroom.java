package com.github.robinjmurphy.cloakroom;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cloakroom<T> {

    private Map<String, Token> tokenMap = new ConcurrentHashMap<String, Token>();
    private Map<Token, T> objectMap = new ConcurrentHashMap<Token, T>();

    public Token checkIn(T object) {
        Token token = new Token();
        objectMap.put(token, object);
        return token;
    }

    public Token checkIn(String key, T object) {
        Token token = new Token();
        tokenMap.put(key, token);
        objectMap.put(token, object);
        return token;
    }

    public T pickUp(Token token) {
        return objectMap.get(token);
    }

    public T pickUp(String key) {
        return objectMap.get(tokenMap.get(key));
    }

}
