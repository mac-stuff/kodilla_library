package com.kodilla.library.mapper;

import com.kodilla.library.domain.Copy;
import com.kodilla.library.domain.CopyDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyMapper {

    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
                copyDto.getId(),
                copyDto.getTitle(),
                copyDto.getRental(),
                copyDto.getIsBorrow());
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                copy.getTitle(),
                copy.getRental(),
                copy.getIsBorrow());
    }

    public List<CopyDto> mapToCopiesDtoList(final List<Copy> copyList) {
        return copyList.stream()
                .map(this::mapToCopyDto)
                .collect(Collectors.toList());
    }
}
