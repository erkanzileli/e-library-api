package com.elibrary.elibrary.security;

public class SecurityConstants {
    public static final String SIGN_UP_URL = "/users/sign-up";
    public static final String SECRET = "kudur";
    public static final long EXPIRATION_TIME = 432_000_000; // 5 gün
    public static final String TOKEN_PREFIX = "JWT ";
    public static final String HEADER_STRING = "Authorization";

}
