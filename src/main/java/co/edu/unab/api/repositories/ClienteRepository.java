package co.edu.unab.api.repositories;

import java.util.ArrayList;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import co.edu.unab.api.models.ClienteModel;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteModel , String> {
    
    ArrayList<ClienteModel> findByNombre(String nombre);
    ArrayList<ClienteModel> findByNombreAndApellido(String nombre, String apellido);
    @Query(value = "{'address.ciudad':?0,'address.departamento':?1}", fields="{'nombre':1, 'apellido':1}")
    ArrayList<ClienteModel> clientexCiudad(String ciudad, String departamento);

    ArrayList<ClienteModel>findByPuntosGreaterThanEqual(long puntos);

    @Query("{'puntos' :{$lte:?0}}")
    ArrayList<ClienteModel> clientesPorMenorPunto(Long puntos);
    
}

