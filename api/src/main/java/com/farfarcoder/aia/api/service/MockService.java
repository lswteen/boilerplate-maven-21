package com.farfarcoder.aia.api.service;

import com.farfarcoder.aia.api.domain.MockData;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class MockService {

    public List<MockData> getMockDataList() {
        List<MockData> list = new ArrayList<>();
        list.add(new MockData(UUID.randomUUID().toString(), "Mock Item 1", "Description for item 1"));
        list.add(new MockData(UUID.randomUUID().toString(), "Mock Item 2", "Description for item 2"));
        list.add(new MockData(UUID.randomUUID().toString(), "Mock Item 3", "Description for item 3"));
        return list;
    }
}
