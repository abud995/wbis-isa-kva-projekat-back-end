package wis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import wis.domain.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long>{

}
