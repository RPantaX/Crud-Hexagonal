package org.example.arquitecturahexagonal.domain.ports.out;

import org.example.arquitecturahexagonal.domain.models.AditionalTaskInfo;

public interface ExternalServicePort {
    AditionalTaskInfo getAdditionalTaskInfo(Long taskId);
}
