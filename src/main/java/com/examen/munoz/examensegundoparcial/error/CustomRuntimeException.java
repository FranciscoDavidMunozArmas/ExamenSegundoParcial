package com.examen.munoz.examensegundoparcial.error;

import lombok.Getter;

@Getter
public class CustomRuntimeException extends RuntimeException {
    public final int code;

    public CustomRuntimeException(String arg0, int code) {
        super(arg0);
        this.code = code;
    }

}
