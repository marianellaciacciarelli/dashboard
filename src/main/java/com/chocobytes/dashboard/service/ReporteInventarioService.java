package com.chocobytes.dashboard.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chocobytes.dashboard.DTO.ProductoCantidadDTO;
import com.chocobytes.dashboard.model.ReporteInventario;
import com.chocobytes.dashboard.repository.ReporteInventarioRepository;

@Service

public class ReporteInventarioService {
    @Autowired
    private ReporteInventarioRepository reporteInventarioRepository; // variable minuscula

    public List<ReporteInventario> listarReporteInventario() {

        return reporteInventarioRepository.findAll(); // trae todos los reportes de reporte invenrario

    }
    public ReporteInventario guardarReporteInventario(List<ProductoCantidadDTO> productos){
        int total = productos.stream()
                .mapToInt(ProductoCantidadDTO::getCantidad)
                .sum();

        ReporteInventario reporte = new ReporteInventario();
        reporte.setFechaHora(LocalDateTime.now());
        reporte.setCantidadProductoTotales(total);

        return reporteInventarioRepository.save(reporte);


    }
}
