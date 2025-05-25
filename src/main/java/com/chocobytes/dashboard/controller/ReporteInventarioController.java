package com.chocobytes.dashboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chocobytes.dashboard.DTO.ProductoCantidadDTO;
import com.chocobytes.dashboard.model.ReporteInventario;
import com.chocobytes.dashboard.service.ReporteInventarioService;

@RestController // controlador de tipo rest(api )
@RequestMapping("/reportes-inventario") // url...manda reporte de base de datos
public class ReporteInventarioController {
    @Autowired // inicializar la variable x detrás
    private ReporteInventarioService reporteInventarioService;

    @GetMapping
    public List<ReporteInventario> listarReporteInventario() {
        return reporteInventarioService.listarReporteInventario();

    }
    @PostMapping

    public ReporteInventario crearReporteInventario(@RequestBody List<ProductoCantidadDTO>productos){  //avisa que va a recibir algo en el cuerpo de la peticion
        return reporteInventarioService.guardarReporteInventario(productos);


    }
    
}
