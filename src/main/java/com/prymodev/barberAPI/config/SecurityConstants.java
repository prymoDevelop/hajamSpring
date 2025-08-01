package com.prymodev.barberAPI.config;

public class SecurityConstants {

    public static final String SECRET = "firas@gmail.com";
    public static final long EXPIRATION_TIME = 864000000;
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String[] WHITE_LIST = {
            "/api/v1/login",
            "/swagger-ui/**",
            "/swagger-ui.html",
            "/v3/api-docs/**",
            "/v3/api-docs",
            "/swagger-resources/**",
            "/webjars/**",
            "/api/v1/barbers"
    };
}
