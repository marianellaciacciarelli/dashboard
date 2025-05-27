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

@RestController  //Declara esta clase como un controlador REST. Spring se encargará de exponer los métodos como endpoints web (API).
@RequestMapping("/reportes-inventario") //Indica que todos los métodos dentro de esta clase estarán accesibles bajo la URL
public class ReporteInventarioController {
    @Autowired //Le dice a Spring que inyecte automáticamente una instancia de ReporteInventarioService. Esto se llama inyección de dependencias.
    private ReporteInventarioService reporteInventarioService; //Declara una variable de tipo ReporteInventarioService, que se usará para llamar a los métodos que hacen el trabajo real (como guardar o listar reportes).



    @GetMapping // Indica que el método siguiente responderá a una solicitud HTTP GET (por ejemplo, cuando un usuario o sistema pida ver los reportes).
    public List<ReporteInventario> listarReporteInventario() { //Define el método listarReporteInventario, que devolverá una lista de reportes de inventario.
        return reporteInventarioService.listarReporteInventario(); //Llama al método listarReporteInventario() del servicio para obtener los datos, y luego los devuelve como respuesta al cliente.



    }
    @PostMapping //Indica que el siguiente método responderá a una solicitud HTTP POST, que normalmente se usa para crear o enviar datos.

    public ReporteInventario crearReporteInventario(@RequestBody List<ProductoCantidadDTO>productos){  // Define el método crearReporteInventario, que recibe en el cuerpo del POST una lista de productos con cantidades.
        //El uso de @RequestBody indica que los datos vendrán en formato JSON desde el cliente.

        return reporteInventarioService.guardarReporteInventario(productos); //Llama al método guardarReporteInventario del servicio, pasando la lista de productos, y devuelve el reporte recién creado.

    }
    
}
