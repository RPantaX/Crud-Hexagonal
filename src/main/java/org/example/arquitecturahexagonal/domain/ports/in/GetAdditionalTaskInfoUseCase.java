package org.example.arquitecturahexagonal.domain.ports.in;

import org.example.arquitecturahexagonal.domain.models.AditionalTaskInfo;

public interface GetAdditionalTaskInfoUseCase {
    AditionalTaskInfo getAdditionalTaskInfo(Long id);

}
