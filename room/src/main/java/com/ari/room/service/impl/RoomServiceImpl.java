package com.ari.room.service.impl;


import com.ari.room.model.entity.Room;
import com.ari.room.repository.RoomRepository;
import com.ari.room.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findAllDepartment() {
        return roomRepository.findAll();
    }
}