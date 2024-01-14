package org.example.arquitecturahexagonal.domain.ports.in;

import org.example.arquitecturahexagonal.domain.models.Task;

public interface CreateTaskUseCase {
    Task createTask(Task task);
}
