package com.kodilla.library.controller;

import com.kodilla.library.domain.Title;
import com.kodilla.library.domain.TitleDto;
import com.kodilla.library.mapper.TitleMapper;
import com.kodilla.library.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/title")
public class TitleController {

    private final DBService service;
    private final TitleMapper titleMapper;

    @Autowired
    public TitleController(DBService service, TitleMapper titleMapper) {
        this.service = service;
        this.titleMapper = titleMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTitles")
    public List<TitleDto> getTitles() {
        List<Title> titles = service.getAllTitles();
        return titleMapper.mapToTitlesDtoList(titles);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getTitle")
    public TitleDto getTitle(@RequestParam Long TitleId) throws TitleNotFoundException {
        return titleMapper.mapToTitleDto(
                service.getTitle(TitleId).orElseThrow(TitleNotFoundException::new)
        );
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteTitle")
    public void deleteTitle(@RequestParam Long TitleId) {
        service.deleteTitle(TitleId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createTitle", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTask(@RequestBody TitleDto titleDto) {
        Title title = titleMapper.mapToTitle(titleDto);
        service.saveTitle(title);
    }
}
