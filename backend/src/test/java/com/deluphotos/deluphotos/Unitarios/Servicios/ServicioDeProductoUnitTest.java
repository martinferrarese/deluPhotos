package com.deluphotos.deluphotos.Unitarios.Servicios;

import com.deluphotos.deluphotos.Entidades.Producto;
import com.deluphotos.deluphotos.Repositorios.RepositorioDeProducto;
import com.deluphotos.deluphotos.Servicios.ServicioDeProducto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ServicioDeProductoUnitTest {

    @Mock
    private RepositorioDeProducto mockRepositorioDeProducto;

    @InjectMocks
    private ServicioDeProducto servicioDeProducto;

    private Producto producto1 = new Producto();
    private Producto producto2= new Producto();
    private Producto producto3= new Producto();
    private List<Producto> resultado = null;

    @Test
    public void seObtienenTodosLosProductos(){
        dadoQueLaBasePoseeTresProductos();
        cuandoSeObtienenTodosLosProductos();
        entoncesSeObtienenTresProductos();
    }

    private List<Producto> inicializaTresProductos() {
        List<Producto> productos = new LinkedList<>();
        producto1.setNombre("Tazas");
        producto1.setPrecio(190L);
        producto1.setDescripción("Tazas re copadas");

        producto2.setNombre("Polariod");
        producto2.setPrecio(50L);
        producto2.setDescripción("Las mejores polaroid");

        producto3.setNombre("Remera");
        producto3.setPrecio(870L);
        producto3.setDescripción("Remera de lo maś cheta");

        productos.add(producto1);
        productos.add(producto2);
        productos.add(producto3);

        return productos;
    }

    private void dadoQueLaBasePoseeTresProductos() {
        List<Producto> productos = inicializaTresProductos();
        when(mockRepositorioDeProducto.findAll()).thenReturn(productos);
    }

    private void cuandoSeObtienenTodosLosProductos() {
        resultado = servicioDeProducto.obtenerTodosLosProductos();
    }

    private void entoncesSeObtienenTresProductos() {
        assertThat(resultado.size()).isEqualTo(3);
        assertThat(resultado.get(0).getNombre()).isEqualTo(producto1.getNombre());
        assertThat(resultado.get(1).getPrecio()).isEqualTo(producto2.getPrecio());
        assertThat(resultado.get(2).getDescripción()).isEqualTo(producto3.getDescripción());
    }
}
