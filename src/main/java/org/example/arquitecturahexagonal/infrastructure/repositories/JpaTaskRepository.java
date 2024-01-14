package org.example.arquitecturahexagonal.infrastructure.repositories;

import org.example.arquitecturahexagonal.infrastructure.entities.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface JpaTaskRepository extends JpaRepository<TaskEntity, Long> {
}
