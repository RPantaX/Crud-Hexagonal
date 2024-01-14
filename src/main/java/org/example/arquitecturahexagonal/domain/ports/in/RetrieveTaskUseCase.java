package org.example.arquitecturahexagonal.domain.ports.in;

import org.example.arquitecturahexagonal.domain.models.Task;

import java.util.List;
import java.util.Optional;

public interface RetrieveTaskUseCase {
    Optional<Task> getTask(Long id);
    List<Task> getAllTasks();
}
