package org.example.arquitecturahexagonal.application.usecases;

import org.example.arquitecturahexagonal.domain.models.Task;
import org.example.arquitecturahexagonal.domain.ports.in.CreateTaskUseCase;
import org.example.arquitecturahexagonal.domain.ports.out.TaskRepositoryPort;

public class CreateTaskUseCaseImpl implements CreateTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public CreateTaskUseCaseImpl(TaskRepositoryPort taskRepositoryPort) {
        this.taskRepositoryPort = taskRepositoryPort;
    }

    @Override
    public Task createTask(Task task) {
        return taskRepositoryPort.save(task);
    }
}
