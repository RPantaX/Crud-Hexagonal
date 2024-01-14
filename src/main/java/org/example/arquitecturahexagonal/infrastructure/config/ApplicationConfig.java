package org.example.arquitecturahexagonal.infrastructure.config;

import org.example.arquitecturahexagonal.application.services.TaskService;
import org.example.arquitecturahexagonal.application.usecases.*;
import org.example.arquitecturahexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import org.example.arquitecturahexagonal.domain.ports.out.ExternalServicePort;
import org.example.arquitecturahexagonal.domain.ports.out.TaskRepositoryPort;
import org.example.arquitecturahexagonal.infrastructure.adapters.ExternalServiceAdapter;
import org.example.arquitecturahexagonal.infrastructure.repositories.JpaTaskRepositoryAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public TaskService taskService (TaskRepositoryPort taskRepositoryPort, GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase){
        return new TaskService(
                new CreateTaskUseCaseImpl(taskRepositoryPort),
                new RetrieveTaskUseCaseImpl(taskRepositoryPort),
                new UpdateTaskUseCaseImpl(taskRepositoryPort),
                new DeleteTaskUseCaseImpl(taskRepositoryPort),
                getAdditionalTaskInfoUseCase
        );
    }
    @Bean
    public TaskRepositoryPort taskRepositoryPort(JpaTaskRepositoryAdapter jpaTaskRepositoryAdapter){
        return jpaTaskRepositoryAdapter;
    }
    @Bean
    public GetAdditionalTaskInfoUseCase getAdditionalTaskInfoUseCase(ExternalServicePort externalServicePort) {
        return new GetAdditionalTaskInfoUseCaseImpl(externalServicePort);
    }
    @Bean
    public ExternalServicePort externalServicePort(){
        return new ExternalServiceAdapter();
    }
}
