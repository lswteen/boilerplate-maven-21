package com.farfarcoder.aia.api.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class MockModel {
    private String id;
    private String name;
    private String internalCode; // Example of a field that might not map 1:1 or logic differences
    private String description;
}
