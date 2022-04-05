package com.ecole.MySchoo.ServiceImpl;

import com.ecole.MySchoo.dto.RoomResponseDto;
import com.ecole.MySchoo.model.Room;
import com.ecole.MySchoo.repository.RoomRepository;
import com.ecole.MySchoo.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public List<Room> findAllRoom() {
        return roomRepository.findAll();
    }

    @Override
    public Room findRoomById(Long id) {
        return roomRepository.findById(id).get();
    }

    @Override
    public Room createRoom(RoomResponseDto roomResponseDto) {
        Room room = new Room();
        room.setRoomNumber(roomResponseDto.getRoomNumber());
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Long id, RoomResponseDto roomResponseDto) {
        Room room=roomRepository.findById(id).get();
        room.setRoomNumber(roomResponseDto.getRoomNumber());
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
