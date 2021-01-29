package com.kodilla.library.mapper;

import com.kodilla.library.domain.Copy;
import com.kodilla.library.domain.CopyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CopyMapper {

    @Autowired
    private TitleMapper titleMapper;

    public Copy mapToCopy(final CopyDto copyDto) {
        return new Copy(
                copyDto.getId(),
                titleMapper.mapToTitle(copyDto.getTitle()),
                copyDto.getIsBorrow());
    }

    public CopyDto mapToCopyDto(final Copy copy) {
        return new CopyDto(
                copy.getId(),
                titleMapper.mapToTitleDto(copy.getTitle()),
                copy.getIsBorrow());
    }

    public List<CopyDto> mapToCopiesDtoList(final List<Copy> copyList) {
        return copyList.stream()
                .map(this::mapToCopyDto)
                .collect(Collectors.toList());
    }

    public List<Copy> mapToCopiesList(final List<CopyDto> copyDtoList) {
        return copyDtoList.stream()
                .map(this::mapToCopy)
                .collect(Collectors.toList());
    }
}
