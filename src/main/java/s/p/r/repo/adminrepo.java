package s.p.r.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;  // ADD THIS LINE
import s.p.r.model.adminmodel;


public interface adminrepo extends JpaRepository<adminmodel,Integer>
{
    public adminmodel findByName(String name);
}