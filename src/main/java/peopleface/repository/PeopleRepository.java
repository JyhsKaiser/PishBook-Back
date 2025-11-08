package peopleface.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peopleface.entity.People;

@Repository
public interface PeopleRepository extends JpaRepository<People, Integer> {
}
