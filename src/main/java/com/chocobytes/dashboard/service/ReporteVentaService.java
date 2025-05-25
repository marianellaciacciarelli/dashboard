package com.chocobytes.dashboard.service;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chocobytes.dashboard.DTO.VentaMontoDTO;
import com.chocobytes.dashboard.model.ReporteVenta;
import com.chocobytes.dashboard.repository.ReporteVentaRepository;

@Service
public class ReporteVentaService {
    @Autowired
    private ReporteVentaRepository reporteVentaRepository; // variable minuscula

    public List<ReporteVenta> listarReporteVenta() {

        return reporteVentaRepository.findAll(); // trae todos los reportes de reporteventa

    }
    public ReporteVenta crearReporte(List<VentaMontoDTO> ventas) {
        Double total = ventas.stream()
                .mapToDouble(VentaMontoDTO::getMontoVenta)
                .sum();

        ReporteVenta reporte = new ReporteVenta();
        reporte.setFechaHora(LocalDateTime.now());
        reporte.setMontoTotalVenta(total);

        return reporteVentaRepository.save(reporte);
    }
}
