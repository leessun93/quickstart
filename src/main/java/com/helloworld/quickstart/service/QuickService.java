package com.helloworld.quickstart.service;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.entity.ItemEntity;
import com.helloworld.quickstart.mappers.QuickMapper;
import com.helloworld.quickstart.repository.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
@Slf4j
public class QuickService {

    //마이바티스 매퍼 오토와이어드
    @Autowired
    private QuickMapper quickMapper;

    //JPA 오토와이어드
    @Autowired
    private ItemRepository itemRepository;

    public boolean registerItem(ItemDto itemDto){
        log.info("service...");

/*      //mybatis를 통한 쿼리 사용
        HashMap<String, Object> paramMap = new HashMap<>();

        paramMap.put("id", itemDto.getId());
        paramMap.put("name", itemDto.getName());

        quickMapper.registerItem(paramMap);*/

        //JPA를 사용한 쿼리 사용
        ItemEntity itemEntity = new ItemEntity();
        itemEntity.setId(itemDto.getId());
        itemEntity.setName(itemDto.getName());

        itemRepository.save(itemEntity);

        return true;
    }

    public ItemDto getItemById(String id){
/*
        //mybatis활용 매퍼

        //해시맵 선언
        HashMap<String, Object> paramMap = new HashMap<>();
        //맵에 id담기
        paramMap.put("id", id);
        //id가 담긴 맵 매퍼에 전달
        HashMap<String, Object> res = quickMapper.findById(paramMap);

        //반환해줄 Dto 선언
        ItemDto itemDto = new ItemDto();
        //res 맵퍼 돌려서 나온 값 String 형변환 후 Dto에 담기
        itemDto.setId((String)res.get("ID"));
        //res 맵퍼 돌려서 나오노 값 String 형변환 후 Dto에 담기
        itemDto.setName((String)res.get("NAME"));

        //Dto 반환
        return itemDto;*/


        //JPA 활용 쿼리돌려오기
        //JPA 내부 함수를 쓰면 자동으로 쿼리가 돌아서 가져온다. 리턴은 옵셔널임
        ItemEntity itemEntity = itemRepository.findById(id).get();
        ItemDto itemDto = new ItemDto();
        itemDto.setId(itemEntity.getId());
        itemDto.setName((String)itemEntity.getName());

        return itemDto;
    }
}
