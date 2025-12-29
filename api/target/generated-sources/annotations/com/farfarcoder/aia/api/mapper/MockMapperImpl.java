package com.farfarcoder.aia.api.mapper;

import com.farfarcoder.aia.api.domain.MockData;
import com.farfarcoder.aia.api.model.MockModel;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-12-29T18:38:00+0900",
    comments = "version: 1.6.3, compiler: javac, environment: Java 24.0.1 (Amazon.com Inc.)"
)
public class MockMapperImpl implements MockMapper {

    @Override
    public MockData toData(MockModel model) {
        if ( model == null ) {
            return null;
        }

        MockData.MockDataBuilder mockData = MockData.builder();

        mockData.id( model.getId() );
        mockData.name( model.getName() );
        mockData.description( model.getDescription() );

        return mockData.build();
    }
}
