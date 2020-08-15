package ie.cct.gergarage.repository;

import ie.cct.gergarage.model.Mech;
import org.springframework.data.repository.Repository;


import java.util.ArrayList;
import java.util.Optional;

public interface MechRepository extends Repository<Mech,Integer> {
    Mech save(Mech mech);
    ArrayList<Mech> findAll();
    void deleteByIdmech(Integer id);



}
