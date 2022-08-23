package com.payhere.payhereassignment.common;

import lombok.Getter;

@Getter
public class SimpleResponseDto {

    private boolean result;

    public SimpleResponseDto(boolean result) {
        this.result = result;
    }
}
