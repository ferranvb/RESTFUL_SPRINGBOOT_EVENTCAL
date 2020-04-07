package cat.emprul.restfulspringboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cat.emprul.restfulspringboot.entity.EventRace;

@Repository
public interface EventRepository extends JpaRepository<EventRace, Long> {

}
