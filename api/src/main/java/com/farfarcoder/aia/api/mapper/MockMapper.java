package com.farfarcoder.aia.api.mapper;

import com.farfarcoder.aia.api.domain.MockData;
import com.farfarcoder.aia.api.model.MockModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MockMapper {
    MockMapper INSTANCE = Mappers.getMapper(MockMapper.class);

    @Mapping(target = "id", source = "id")
    @Mapping(target = "name", source = "name")
    @Mapping(target = "description", source = "description")
    MockData toData(MockModel model);
}
