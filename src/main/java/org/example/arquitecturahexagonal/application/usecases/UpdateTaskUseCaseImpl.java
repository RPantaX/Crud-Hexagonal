package org.example.arquitecturahexagonal.application.usecases;

import org.example.arquitecturahexagonal.domain.models.Task;
import org.example.arquitecturahexagonal.domain.ports.in.UpdateTaskUserCase;
import org.example.arquitecturahexagonal.domain.ports.out.TaskRepositoryPort;

import java.util.Optional;

public class UpdateTaskUseCaseImpl implements UpdateTaskUserCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public UpdateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Optional<Task> updateTask(Long id, Task updateTask) {
        return taskRepositoryPort.update(updateTask);
    }
}
