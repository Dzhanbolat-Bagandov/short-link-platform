package com.bagandov.shortlinkservice;

import com.bagandov.shortlinkservice.api.LongLinkModel;
import com.bagandov.shortlinkservice.domain.LinkPair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/main")
public class MainController {

    @Autowired
    private LinkPairService service;

    @PostMapping(value = "/create")
    public ResponseEntity<LinkPair> create(@RequestBody LongLinkModel longLinkModel) {
        return ResponseEntity.ok(service.create(longLinkModel.getLongLink()));
    }

    @GetMapping(value = "/{shortLink}")
    public ResponseEntity<LinkPair> get(@PathVariable String shortLink) {
        System.out.println("got the request");
        return ResponseEntity.ok(service.findOne(shortLink));
    }
}
