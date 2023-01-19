package com.examen.munoz.examensegundoparcial.utils;

public enum ResponseCodeUtils {
    NOT_FOUND(404),
    SUCCESS(200),
    INTERNAL_ERROR_SERVER(500),
    CREATED(201);

    public final int code;
    ResponseCodeUtils(int code){
        this.code = code;
    }

}
