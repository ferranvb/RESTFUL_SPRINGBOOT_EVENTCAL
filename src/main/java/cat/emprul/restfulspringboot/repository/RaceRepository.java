package cat.emprul.restfulspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cat.emprul.restfulspringboot.entity.Race;

public interface RaceRepository extends JpaRepository<Race, Long> {

}
