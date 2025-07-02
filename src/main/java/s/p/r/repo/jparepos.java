package s.p.r.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import s.p.r.model.bookmodel;

public interface jparepos extends JpaRepository<bookmodel, Integer> {
}
