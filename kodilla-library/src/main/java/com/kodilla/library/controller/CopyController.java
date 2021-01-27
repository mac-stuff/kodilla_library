package com.kodilla.library.controller;

import com.kodilla.library.domain.Copy;
import com.kodilla.library.domain.CopyDto;
import com.kodilla.library.exceptions.CopyNotFoundException;
import com.kodilla.library.mapper.CopyMapper;
import com.kodilla.library.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/copy")
public class CopyController {
    
    private final DBService service;
    private final CopyMapper copyMapper;

    @Autowired
    public CopyController(DBService service, CopyMapper copyMapper) {
        this.service = service;
        this.copyMapper = copyMapper;
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCopies")
    public List<CopyDto> getCopies() {
        List<Copy> copies = service.getAllCopies();
        return copyMapper.mapToCopiesDtoList(copies);
    }

    @RequestMapping(method = RequestMethod.GET, value = "getCopy")
    public CopyDto getCopy(@RequestParam Long copyId) throws CopyNotFoundException {
        return copyMapper.mapToCopyDto(
                service.getCopy(copyId).orElseThrow(CopyNotFoundException::new)
        );
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteCopy")
    public void deleteCopy(@RequestParam Long copyId) {
        service.deleteCopy(copyId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createCopy", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createCopy(@RequestBody CopyDto copyDto) {
        Copy copy = copyMapper.mapToCopy(copyDto);
        service.saveCopy(copy);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateCopy")
    public CopyDto updateCopy(@RequestBody CopyDto copyDto) {
        return copyMapper.mapToCopyDto(service.saveCopy(copyMapper.mapToCopy(copyDto)));
    }
}
