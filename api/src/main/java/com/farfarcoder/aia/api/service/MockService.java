package com.farfarcoder.aia.api.service;

import com.farfarcoder.aia.api.domain.MockData;
import com.farfarcoder.aia.api.mapper.MockMapper;
import com.farfarcoder.aia.api.model.MockModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MockService {

    public List<MockData> getMockDataList() {
        List<MockModel> mockModels = new ArrayList<>();
        mockModels.add(MockModel.builder()
                .id(UUID.randomUUID().toString())
                .name("Mock Item 1")
                .description("Description for item 1")
                .internalCode("INT-001")
                .build());
        mockModels.add(MockModel.builder()
                .id(UUID.randomUUID().toString())
                .name("Mock Item 2")
                .description("Description for item 2")
                .internalCode("INT-002")
                .build());
        mockModels.add(MockModel.builder()
                .id(UUID.randomUUID().toString())
                .name("Mock Item 3")
                .description("Description for item 3")
                .internalCode("INT-003")
                .build());

        return mockModels.stream()
                .map(MockMapper.INSTANCE::toData)
                .toList();
    }
}
