package com.chocobytes.dashboard.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoCantidadDTO {
    private Long id;
    private int cantidad;
}

