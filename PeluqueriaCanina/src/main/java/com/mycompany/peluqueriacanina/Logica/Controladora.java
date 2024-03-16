package com.mycompany.peluqueriacanina.Logica;

import com.mycompany.peluqueriacanina.Persistencia.ControladoraPersistencia;
import java.util.List;

public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMasco, String raza, String color, String observaciones, 
            String nombreDuenio, String celDuenio, String alergico, String ateEsp) {
    
        
        //crear duenio y asignar sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelDuenio(celDuenio);
        
        
        // Crear mascota y asignar sus valores
        Mascota masco = new Mascota();
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergias(alergico);
        masco.setAtencion_especial(ateEsp);
        masco.setUnDuenio(duenio);
        
        controlPersis.guardar(duenio,masco);
        
    }

    public List<Mascota> traerMascotas() {
    
        return controlPersis.traerMascotas();
        
    
    }

    public void borraMascota(int num_cliente) {
    
    controlPersis.borrarMascota(num_cliente);
    
    }

    public Mascota traerMascota(int num_cliente) {
    
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMasco, String raza, String color,
            String observaciones, String alergico, String ateEsp, String nombreDuenio, String celDuenio) {
    
        masco.setNombre(nombreMasco);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAtencion_especial(ateEsp);
        masco.setAlergias(alergico);
        
        //modifico la mascota
        controlPersis.modificarmascota(masco);

        //setear nuevos valores
        Duenio dueno = this.buscarDuenio(masco.getUnDuenio().getId_duenio());
        dueno.setCelDuenio(celDuenio);
        dueno.setNombre(color);
        
        //llamar al modificar dueño
        this.modificarDuenio(dueno);
    
    }

    private Duenio buscarDuenio(int id_duenio) {
    
        return controlPersis.traerDuenio(id_duenio);
        
    }

    private void modificarDuenio(Duenio dueno) {
    
        controlPersis.modificarDuenio(dueno);
    }
    
}
