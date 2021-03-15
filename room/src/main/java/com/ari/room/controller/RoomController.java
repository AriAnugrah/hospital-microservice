package com.ari.room.controller;

import com.ari.room.model.entity.Room;
import com.ari.room.service.RoomService;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("room")
@EnableDiscoveryClient
public class RoomController {

    private RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping("/halo")
    public String halo (){
        return "Halo ini dari room";
    }

    @GetMapping
    public List<Room> findAllDepartment() {
        return roomService.findAllDepartment();
    }
}
