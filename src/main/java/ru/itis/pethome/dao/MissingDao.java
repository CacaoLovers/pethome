package ru.itis.pethome.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.itis.pethome.model.Missing;

import java.util.UUID;

public interface MissingDao extends JpaRepository<Missing, UUID> {

}
