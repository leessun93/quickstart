package com.helloworld.quickstart.controller;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.dto.ResponseDto;
import com.helloworld.quickstart.service.QuickService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class QuickController {

    @Autowired
    private QuickService quickService;

    @GetMapping("/dummy")
    public String dummy(){
        log.info("Dummy1");
        return "{}";
    }

    @GetMapping("/dummy2")
    public String dummy2(){
        log.info("Dummy2");
        return "dummy2";
    }

    @GetMapping("/member")
    public String getMember(@RequestParam("empNo") String empNo,
                            @RequestParam("year") int year){
        //로그찍는건 "키 : {}" , 값 이 기본틀인가보다
        log.info("year : {}", year);
        log.info("empNo : {}" , empNo);
        return "Ok";
    }

    @GetMapping("/company/{id}")
    public String getCompany(@PathVariable("id") String id){
        log.info("id: {}", id);
        return "ok";
    }

/*    @PostMapping("/item")
    public String registerItem(@RequestBody String item){
        log.info("item: {}", item);
        return "ok";
    }*/

    @PostMapping("/item")
    public ResponseDto registerItem(@RequestBody ItemDto item){
        log.info("item: {}", item);

        boolean b = quickService.registerItem(item);
        if(b == true){
            //자동 단축키 = 커서 올리고 alt + enter
            ResponseDto responseDto = new ResponseDto();
            responseDto.setMessage("ok");
            return responseDto;
        }

        //자동 단축키 = 커서 올리고 alt + enter
        ResponseDto responseDto = new ResponseDto();
        responseDto.setMessage("fail");
        return responseDto;
    }

    @GetMapping("/item")
    public ItemDto getItem(@RequestParam("id") String id){
        log.info("컨트롤러진입");

        ItemDto res = quickService.getItemById(id);
        return res;

    }
}
