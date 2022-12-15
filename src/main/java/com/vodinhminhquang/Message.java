package com.vodinhminhquang;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record Message(String message, LocalDateTime created) {
}
