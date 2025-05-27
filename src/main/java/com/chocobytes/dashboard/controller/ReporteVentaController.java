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
public class ReporteVentaController { // Comienza la definición de la clase controladora que manejará las operaciones relacionadas a reportes de ventas.
    @Autowired 
    private ReporteVentaService reporteVentaService; // Define el método listarReporteVenta, que devuelve una lista de reportes de ventas.

    @GetMapping
    public List<ReporteVenta> listarReporteVenta() { //Define el método listarReporteVenta, que devuelve una lista de reportes de ventas.


        return reporteVentaService.listarReporteVenta(); //Llama al servicio reporteVentaService para obtener la lista de reportes y la devuelve al cliente (en JSON).

    }
    @PostMapping // Indica que el método siguiente responde a HTTP POST, usado para enviar o crear datos nuevos.
    public ReporteVenta crearReporteVentas(@RequestBody List<VentaMontoDTO> ventas) { //Define el método crearReporteVentas, que recibe en el cuerpo del POST (en formato JSON) una lista de ventas representadas por VentaMontoDTO.
        return reporteVentaService.crearReporte(ventas); //llama al método del servicio que genera el reporte de ventas a partir de la lista de ventas recibidas, y devuelve ese nuevo reporte.
    }
}


