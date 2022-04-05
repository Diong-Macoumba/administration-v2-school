package com.ecole.MySchoo.service;

import com.ecole.MySchoo.dto.RoomResponseDto;
import com.ecole.MySchoo.model.Room;

import java.util.List;

public interface RoomService {
    List<Room> findAllRoom();
    Room findRoomById(Long id);
    Room createRoom(RoomResponseDto roomResponseDto);
    Room updateRoom(Long  id, RoomResponseDto roomResponseDto);
    void deleteRoom(Long id);
}
