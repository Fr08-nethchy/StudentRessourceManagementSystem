package studentressourcemanagementsystem.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import studentressourcemanagementsystem.POJO.TFEData;

@Repository
public interface TFEDataDao extends JpaRepository<TFEData, Long> {

    TFEData findTFEDataById(Long id);
}
