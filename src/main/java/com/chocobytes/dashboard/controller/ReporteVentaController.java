package com.chocobytes.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chocobytes.dashboard.DTO.VentaMontoDTO;
import com.chocobytes.dashboard.model.ReporteVenta;
import com.chocobytes.dashboard.service.ReporteVentaService;

@RestController // controlador de tipo rest(api )
@RequestMapping("/reportes-ventas")
public class ReporteVentaController {
    @Autowired // inicializar la variable x detrás
    private ReporteVentaService reporteVentaService;

    @GetMapping
    public List<ReporteVenta> listarReporteVenta() {
        return reporteVentaService.listarReporteVenta();

    }
    @PostMapping
    public ReporteVenta crearReporteVentas(@RequestBody List<VentaMontoDTO> ventas) {
        return reporteVentaService.crearReporte(ventas);
    }
}


