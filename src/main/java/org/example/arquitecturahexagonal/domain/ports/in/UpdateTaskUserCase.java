package org.example.arquitecturahexagonal.domain.ports.in;

import org.example.arquitecturahexagonal.domain.models.Task;

import java.util.Optional;

public interface UpdateTaskUserCase {
    Optional<Task> updateTask( Long id, Task updateTask);
}
