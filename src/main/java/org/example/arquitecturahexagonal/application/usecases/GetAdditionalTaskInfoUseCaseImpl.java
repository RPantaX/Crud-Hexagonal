package org.example.arquitecturahexagonal.application.usecases;

import org.example.arquitecturahexagonal.domain.models.AditionalTaskInfo;
import org.example.arquitecturahexagonal.domain.ports.in.GetAdditionalTaskInfoUseCase;
import org.example.arquitecturahexagonal.domain.ports.out.ExternalServicePort;
import org.example.arquitecturahexagonal.domain.ports.out.TaskRepositoryPort;

public class GetAdditionalTaskInfoUseCaseImpl implements GetAdditionalTaskInfoUseCase {
    private final ExternalServicePort externalServicePort;

    public GetAdditionalTaskInfoUseCaseImpl(ExternalServicePort externalServicePort) {
        this.externalServicePort = externalServicePort;
    }

    @Override
    public AditionalTaskInfo getAdditionalTaskInfo(Long id) {
        return externalServicePort.getAdditionalTaskInfo(id);
    }
}
