package com.bagandov.redirectservice;

import com.bagandov.redirectservice.models.LinkPair;
import com.bagandov.redirectservice.models.LongLinkModel;
import com.bagandov.redirectservice.service.ExternalRequestSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class RedirectController {

    @Autowired
    private ExternalRequestSender requestSender;

    @GetMapping(value = "/redirect/{shortLink}")
    public ModelAndView redirect(@PathVariable String shortLink) {
        return new ModelAndView("redirect:" + requestSender.getLinkPair(shortLink).getLongLink());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<LinkPair> createLink(@RequestBody LongLinkModel longLinkModel) {
        return ResponseEntity.ok(requestSender.createLinkPair(longLinkModel.getLongLink()));
    }
}
