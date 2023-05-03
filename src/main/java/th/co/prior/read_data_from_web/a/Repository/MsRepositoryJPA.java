package th.co.prior.read_data_from_web.a.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import th.co.prior.read_data_from_web.a.Entity.MsEntity;

@Repository
public interface MsRepositoryJPA extends JpaRepository<MsEntity,String> {
}
