package com.kata.api.dto.converter;

import com.kata.api.Model.Beers;
import com.kata.api.Model.Styles;
import com.kata.api.dto.BeerDTO;
import com.kata.api.dto.StyleDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class StyleDTOConverter {

    private final ModelMapper modelMapper;

    public StyleDTO convertToDTO(Styles style){
        return modelMapper.map(style,StyleDTO.class);
    }
}
